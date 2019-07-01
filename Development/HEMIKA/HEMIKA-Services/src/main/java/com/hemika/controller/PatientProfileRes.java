package com.hemika.controller;

import com.hemika.repository.PatientDataRep;
import com.hemika.service.PatientDataSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/patient/profile")
public class PatientProfileRes {

    private PatientDataRep pData;
    private PatientDataSer patientDataSer;

    @Autowired
    public PatientProfileRes(PatientDataRep pData, PatientDataSer patientDataSer) {
        this.pData = pData;
        this.patientDataSer = patientDataSer;
    }

    @Path("/data")
    @GET
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    public  void getPatientData() throws Exception {
//        Response response = this.securitySer.Login(data);
        String nationalId = "10101012121211";
        System.out.println(this.patientDataSer.getPatient(nationalId));

    }

}
