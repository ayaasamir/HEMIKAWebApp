package com.hemika.controller;


//import com.hemika.model.UserData;
import com.hemika.model.UserDtoData;
import com.hemika.repository.CreateUserRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;


@Path("user")
public class CreateUserRes {
    @Autowired
    private CreateUserRep rep;
    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createNewUser(UserDtoData data ) throws Exception {
        System.out.println("data is received");
        System.out.println(data.toString());
        this.rep.insertNewUser(data);

    }
}


