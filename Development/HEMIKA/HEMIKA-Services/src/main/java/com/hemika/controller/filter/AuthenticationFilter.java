package com.hemika.controller.filter;

import com.hemika.model.annotation.Authenticate;
import com.hemika.model.user.User;
import com.hemika.repository.SecurityRep;
import org.springframework.beans.factory.annotation.Autowired;
import com.hemika.service.SecurityManager;
import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Base64;

@Authenticate
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    public static final String AUTH_USER = "Authenticated-User";

    private SecurityRep userService;
    private SecurityManager securityManager;

    @Autowired
    public AuthenticationFilter(
            SecurityRep userService,
            SecurityManager securityManager) {
        this.userService = userService;
        this.securityManager = securityManager;

    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        try {
            String authorizationHeader =
                    requestContext.getHeaderString("authorization");
            if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
//                throw new NotAuthorizedException("Authorization header must be provided");
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }
            // Extract the token from the HTTP Authorization header
            String token = authorizationHeader.substring("Bearer ".length()).trim();
            //Validate the token
            validateToken(token, requestContext);

//            ConfigManager.logger.endDebugLog(session, AuthenticationFilter.class, "filter");
        } catch (Exception e) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

    private void validateToken(String token, ContainerRequestContext requestContext) {
        try {
            String key = new String(Base64.getDecoder().decode(token), "US-ASCII");
            String[] parts = key.split(":");
            if (parts.length == 3) {
                String hashedPassword = parts[0];
                String username = parts[1];
                long ticks = Long.parseLong(parts[2]);
                User userOfToken = userService.getUserByUserName(username);
                if (userOfToken == null)
                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("User not found").build());
                if (!userOfToken.isActive())
                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("User Deactivated!").build());

//                String userPassword = userOfToken.getUserPassword();
                String newToken = securityManager.generateToken(userOfToken.getUserName(), userOfToken.getUserPassword(), ticks);
                if (token.equals(newToken)) {
                    userOfToken.setUserPassword(null);
                    requestContext.setProperty(AuthenticationFilter.AUTH_USER, userOfToken);
//                    System.out.println(requestContext.getProperty("Authenticated-User"));
//                        session.setUserName(userOfToken.getFirstName() + " " + userOfToken.getLastName());
                } else
                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Incorrect user password").build());
            } else
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Invalid Token!").build());
        } catch (Exception ex) {
//           throw new NPCBusinessException("Exception happened during validate token");
            requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).entity("xception happened during validate token").build());
        }
    }
}
