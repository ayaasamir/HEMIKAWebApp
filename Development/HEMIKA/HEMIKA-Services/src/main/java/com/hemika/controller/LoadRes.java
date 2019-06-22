package com.hemika.controller;

//import com.am.training.trainingapp.models.UserType;
//import com.am.training.trainingapp.repository.LoadRep;
import com.hemika.model.UserTypeVtoData;
import com.hemika.repository.LoadRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/load")
public class LoadRes {
    private LoadRep loadRep;

    @Autowired
    public LoadRes(LoadRep loadRep){ this.loadRep = loadRep;}


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/userType")
    public List<UserTypeVtoData> findData() { return this.loadRep.findUserType(); }

}
