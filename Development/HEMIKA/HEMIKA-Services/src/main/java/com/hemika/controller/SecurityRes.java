package com.hemika.controller;

import com.hemika.model.security.LoginUserDTO;
import com.hemika.service.SecuritySer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

}
