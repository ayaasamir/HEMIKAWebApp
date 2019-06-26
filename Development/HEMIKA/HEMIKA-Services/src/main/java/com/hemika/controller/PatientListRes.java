package com.hemika.controller;

import com.hemika.data.PatientListDto;
import com.hemika.model.patientListVTO;
import com.hemika.repository.PatientListRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/patientList")
public class PatientListRes {
    @Autowired
    private PatientListRep repository;
    //    @POST
//    @Path("/search")
//    @Produces(MediaType.APPLICATION_JSON)
//    public void search(PatientListDto data){
//        System.out.println("data is recieved success");
//        System.out.println(data.toString());
//        this.repository.insertNewPatien(data);
//        System.out.println("data is succeeded insert in data base");
////        List<patientListVTO> result = this.repository.findIntendedPatient();
////        return result;
//
//    }
//    @GET
//    @Path("findPatientData")
//    @Produces(MediaType.APPLICATION_JSON)
//    public PatientListDto findPatientData(){
//        PatientListDto data = new PatientListDto();
//        data.setPatientName("enas");
//        data.setPatientStatus("Treated");
//
//    return data;
//    }
    @POST
    @Path("/findPatient")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<patientListVTO> findPatientData(PatientListDto data) {
        if ((data.getPatientName() != null && (data.getPatientStatus() == null ))&& ((data.getStartDate() == null )&& (data.getEndDate() == null)) ) {
            List<patientListVTO> result = this.repository.findByName(data.getPatientName());
            return result;
        }
        else if  ((data.getPatientName() == null && (data.getPatientStatus() != null ))&& ((data.getStartDate() == null )&& (data.getEndDate() == null)) ){
            List<patientListVTO> result = this.repository.findBystatus(data.getPatientStatus());
            System.out.println(data);
            System.out.println(result);
            return result;
        }
        else if (data.getPatientName() != "" && data.getPatientStatus() != "" && data.getStartDate() == "" && data.getEndDate() == ""){
            List<patientListVTO> result = this.repository.findByNameAndStatus(data.getPatientName(),data.getPatientStatus());
            return result;
        }
        else if ((data.getPatientName() == null && (data.getPatientStatus() == null ))&& ((data.getStartDate() != null )&& (data.getEndDate() != null))){
            List<patientListVTO> result = this.repository.findByDate(data.getStartDate(),data.getEndDate());
            return result;
        }
        else if ((data.getPatientName() != null && (data.getPatientStatus() != null ))&& ((data.getStartDate() != null )&& (data.getEndDate() != null))){
            List<patientListVTO> result = this.repository.findPatientByAllData(data.getPatientName(),data.getPatientStatus(),data.getStartDate(),data.getEndDate());
            return result;
        }
        else{
            //TODO end exception/ error handling instead of find all
            List<patientListVTO> result = this.repository.findAll();
            return result;
        }


    }
//    @POST
//    @Path("findBystatus")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<patientListVTO> findPatientData2(String patientStaus){
//        List<patientListVTO> result = this.repository.findBystaus(patientStaus);
//        return result;
//    }
//    @POST
//    @Path("findBynameAndstatus")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<patientListVTO> findPatientData3( String patientName,String patientStaus){
//        List<patientListVTO> result = this.repository.findByNameAndStatus(patientName,patientStaus);
//        return result;
//    }



}
