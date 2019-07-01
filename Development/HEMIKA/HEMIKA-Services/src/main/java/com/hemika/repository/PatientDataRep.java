package com.hemika.repository;

import com.hemika.model.patientData.ComingExamineData;
import com.hemika.model.patientData.PatientData;
import com.hemika.model.patientData.TreatmentData;
import com.hemika.model.patientData.rm.PatientDataRM1;
import com.hemika.model.patientData.rm.PatientDataRM2;
import com.hemika.model.patientData.rm.PatientDataRM3;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class PatientDataRep {
    private JdbcTemplate jdbcTemplate;

    public PatientDataRep(JdbcTemplate jdbc) {
        this.jdbcTemplate = jdbc;
    }

    public PatientData getPatientData(String nationalId){
        String sql1 = "SELECT CONCAT(`first_name`, ' ', `last_name`) As `name`, YEAR(CURDATE()) - YEAR(`user_birth_date`) AS age, `status` FROM ((mydb.user_t U INNER JOIN mydb.patient_t P ON U.national_id = P.user_t_national_id) INNER JOIN mydb.status S ON P.status_id = S.id) WHERE `national_id` = ?;";
        RowMapper<PatientData> rowMapper1 = new PatientDataRM1();
        PatientData patientData = jdbcTemplate.queryForObject(sql1, rowMapper1, nationalId);
        return patientData;
    }

    public ComingExamineData getComingExamineData(String nationalId){
        String sql = "SELECT `date` AS `coming_date`, `temperature`, `pulse`, `high_bp`, `low_bp` FROM mydb.primary_examination_t PEX WHERE patient_visit_t_id = (SELECT MAX(`id`) FROM mydb.patient_visit_t PV WHERE PV.patient_t_user_t_national_id = ?);";
        RowMapper<ComingExamineData> rowMapper2 = new PatientDataRM2();
        ComingExamineData comingExamineData = jdbcTemplate.queryForObject(sql, rowMapper2, nationalId);
        return comingExamineData;
    }

    public List<TreatmentData> getTreatmentData(String nationalId){
        String sql = "SELECT `diagnosis`, `comment`, `medicine_name`, `dosage`, (24 / HOUR(`period`)) AS `times`, CONCAT(`first_name`, ' ', `last_name`) As `Doctor`, `start_date` AS `date` FROM (mydb.user_t U INNER JOIN mydb.treatment_t T ON  U.national_id = T.doctor_t_user_t_national_id) INNER JOIN mydb.patient_visit_t PV ON T.patient_visit_t_id = PV.id WHERE PV.id = (SELECT MAX(`id`) FROM mydb.patient_visit_t PV WHERE PV.patient_t_user_t_national_id = ?);";
        RowMapper<TreatmentData> rowMapper3 = new PatientDataRM3();
        List<TreatmentData> treatmentData = jdbcTemplate.query(sql, rowMapper3, nationalId);
        return treatmentData;
    }
}
