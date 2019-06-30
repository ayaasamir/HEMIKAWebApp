package com.hemika.repository;

import com.hemika.model.createVisitorVTORM;
import com.hemika.model.patientListVTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CreateVisitorRep {
    private JdbcTemplate jdbc;
    @Autowired
    public CreateVisitorRep(JdbcTemplate jdbc){
        this.jdbc=jdbc;
    }
    public List<patientListVTO> AddingPatientName(String name){

        String sql = "SELECT concat(first_name,' ',last_name) fullname  FROM  mydb.user_t U INNER JOIN mydb.patient_t P ON U.national_id = P.user_t_national_id WHERE `first_name` = ?;";
        RowMapper<patientListVTO> patientRM= new createVisitorVTORM();
        List<patientListVTO> patients= jdbc.query(sql, patientRM, name);
        return patients;
    }
}
