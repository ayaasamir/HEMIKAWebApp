package com.hemika.repository;

import com.hemika.model.patientListVTO;
import com.hemika.model.patientListVTORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class CreateVisitorRep {
    private JdbcTemplate jdbc;
    @Autowired
    public CreateVisitorRep(JdbcTemplate jdbc){
        this.jdbc=jdbc;
    }
    public List<patientListVTO> AddingPatientName(String name){

        String sql = "SELECT patient_name,patient_status,start_date,last_check FROM patient where patient_name=?";
        RowMapper<patientListVTO> patientRM= new patientListVTORM();
        List<patientListVTO> patients= jdbc.query(sql, patientRM, name);
        return patients;
    }
}
