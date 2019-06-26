package com.hemika.controller;

import com.hemika.model.patientListVTO;
import com.hemika.repository.CreateVisitorRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/create/visitor")
public class CreateVisitorRes {
    @Autowired
    private CreateVisitorRep repository;
    @POST
    @Path("findPatient")
    @Produces(MediaType.APPLICATION_JSON)
    public List<patientListVTO> findPatientData(String name) {

        List<patientListVTO> result = this.repository.AddingPatientName(name);
        return result;
    }
}
