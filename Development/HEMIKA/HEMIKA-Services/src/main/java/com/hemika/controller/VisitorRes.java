package com.hemika.controller;

import com.hemika.model.VisitorDtoData;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/visitor")
public class VisitorRes {

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(VisitorDtoData data){
//    VisitorDtoData visitorData=new VisitorDtoData();
        System.out.println("Data is saved");
        System.out.println(data.toString());
    }


}
