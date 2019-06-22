package com.hemika.controller;

import com.hemika.model.DoctorDtoData;
import com.hemika.repository.DocDetailsRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/userDoctor")
public class DocDetailsRes {
    @Autowired
   private DocDetailsRep rep;


    @POST
    @Path("/createDoc")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createNewDoctor(DoctorDtoData docData){
        System.out.println("data is received");
        System.out.println(docData.toString());
        this.rep.insertNewDoctor(docData);
    }
}
