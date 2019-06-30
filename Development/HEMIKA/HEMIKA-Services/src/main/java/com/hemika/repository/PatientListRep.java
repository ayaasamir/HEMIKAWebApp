package com.hemika.repository;

import com.hemika.model.patientListVTO;
import com.hemika.model.patientListVTORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientListRep {
    private JdbcTemplate jdbc;
    @Autowired
    public PatientListRep(JdbcTemplate jdbc){
        this.jdbc=jdbc;
    }


    public List<patientListVTO> findByName( String name){

       String sql = "SELECT `date`,`status`, concat(first_name,' ',last_name) fullname   FROM mydb.primary_examination_t,  mydb.status, mydb.user_t WHERE (`patient_visit_t_id` = (SELECT MAX(`id`) FROM mydb.patient_visit_t WHERE `patient_t_user_t_national_id` = (SELECT `national_id` FROM mydb.user_t WHERE `first_name` = ?))) and (`first_name` = ?) and (`id`=(SELECT `status_id` FROM mydb.patient_t WHERE `user_t_national_id` = (SELECT `national_id` FROM mydb.user_t WHERE `first_name` = ?)))";
        RowMapper<patientListVTO> patientRM= new patientListVTORM();
        List<patientListVTO> patients=  this.jdbc.query(sql, patientRM, name,name,name);
        return patients;
    }


}
