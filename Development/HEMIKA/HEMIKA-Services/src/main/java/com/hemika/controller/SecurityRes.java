package com.hemika.controller;

import com.hemika.controller.filter.AuthenticationFilter;
import com.hemika.model.annotation.Authenticate;
import com.hemika.model.security.LoginUserDTO;
import com.hemika.model.user.User;
import com.hemika.service.SecuritySer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/security")
public class SecurityRes {
    private SecuritySer securitySer;

    @Autowired
    public SecurityRes(SecuritySer securitySer){
        this.securitySer = securitySer;
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginUserDTO data) throws Exception {
        Response response = this.securitySer.Login(data);
        return response;
    }

    @Path("test")
    @GET
    @Authenticate
    public void sayHello(@Context ContainerRequestContext requestContext){
        User currentUser = (User)requestContext.getProperty(AuthenticationFilter.AUTH_USER);
        System.out.println("Testing Authorization Header");
    }

}
