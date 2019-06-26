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

    //    public void insertNewPatien(PatientListDto data){
//        String sql = "INSERT INTO patient(patient_name,patient_status,start_date,end_date) values (?,?,?,?)";
//        this.jdbc.update(sql,data.getPatientName(),data.getPatientStatus(),data.getStartDate(),data.getEndDate());
//        }
//    public List<patientListVTO> findByName(String name){
//
//        String sql = "SELECT patient_name,patient_status,start_date,last_check FROM patient where patient_name=?";
//        RowMapper<patientListVTO> patientRM= new patientListVTORM();
//        List<patientListVTO> patients=  this.jdbc.query(sql, patientRM, name);
//        return patients;
//    }


    public List<patientListVTO> findByName( String name){

//        String sql = "SELECT `date`, `status`  FROM mydb.primary_examination_t,  mydb.status WHERE (`patient_visit_t_id` = (SELECT MAX(`id`) FROM mydb.patient_visit_t WHERE `patient_t_user_t_national_id` = (SELECT `national_id` FROM mydb.user_t WHERE `first_name` = ?))) and (`id`=(SELECT `status_id` FROM mydb.patient_t WHERE `user_t_national_id` = (SELECT `national_id` FROM mydb.user_t WHERE `first_name` = ?)));";
        String sql = "SELECT `date`,`status`, `name`  FROM mydb.primary_examination_t,  mydb.status, mydb.user_t WHERE (`patient_visit_t_id` = (SELECT MAX(`id`) FROM mydb.patient_visit_t WHERE `patient_t_user_t_national_id` = (SELECT `national_id` FROM mydb.user_t WHERE `name` = ?))) and (`name` = ?) and (`id`=(SELECT `status_id` FROM mydb.patient_t WHERE `user_t_national_id` = (SELECT `national_id` FROM mydb.user_t WHERE `name` = ?)));";
        RowMapper<patientListVTO> patientRM= new patientListVTORM();
        List<patientListVTO> patients=  this.jdbc.query(sql, patientRM, name, name,name);
        return patients;
    }
    public List<patientListVTO> findBystatus( String status){

        String sql = "SELECT patient_name,patient_status,start_date,last_check FROM patient where patient_status=?";
        List<patientListVTO> patients= this.jdbc.query(sql, new patientListVTORM(),status );
        return patients;
    }
    public List<patientListVTO> findByNameAndStatus( String name,String status){

        String sql = "SELECT patient_name,patient_status,start_date,last_check FROM patient where patient_name=? and patient_status=?";
        List<patientListVTO> patients= this.jdbc.query(sql, new patientListVTORM() ,name,status);
        return patients;
    }
    public List<patientListVTO> findByDate( String StartDate,String EndDate){

        String sql = "SELECT patient_name,patient_status,start_date,last_check FROM patient where  start_date>=? and start_date<=?";
        List<patientListVTO> patients= this.jdbc.query(sql, new patientListVTORM() ,StartDate,EndDate);
        return patients;
    }
    public List<patientListVTO> findPatientByAllData( String name , String status,String StartDate,String EndDate){

        String sql = "SELECT patient_name,patient_status,start_date,last_check FROM patient where patient_name=? and patient_status=? and start_date>=? and start_date<=?";
        List<patientListVTO> patients= this.jdbc.query(sql, new patientListVTORM() ,name,status,StartDate,EndDate);
        return patients;
    }
    public List<patientListVTO> findAll( ){

        String sql = "SELECT patient_name,patient_status,start_date,last_check FROM patient";
        List<patientListVTO> patients = this.jdbc.query(sql, new patientListVTORM());
        return patients;
    }

}
