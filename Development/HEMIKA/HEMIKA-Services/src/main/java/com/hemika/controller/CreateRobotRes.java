package com.hemika.controller;

import com.hemika.model.RobotDtoData;
import com.hemika.repository.CreateRobotRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("robot")
public class CreateRobotRes {
    @Autowired
    private CreateRobotRep rep;
    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createNewRobot(RobotDtoData data){
        System.out.println("data is received");
        System.out.println(data.toString());
        this.rep.insertNewRobot(data);
    }
}


