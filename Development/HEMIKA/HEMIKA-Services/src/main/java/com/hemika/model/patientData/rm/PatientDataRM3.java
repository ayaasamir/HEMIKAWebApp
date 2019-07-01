package com.hemika.model.patientData.rm;

import com.hemika.model.patientData.TreatmentData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDataRM3 implements RowMapper<TreatmentData> {
    @Override
    public TreatmentData mapRow(ResultSet row, int i) throws SQLException {

        TreatmentData treatmentData = new TreatmentData();
        treatmentData.setDiagnosis(row.getString("diagnosis"));
        treatmentData.setComment(row.getString("comment"));
        treatmentData.setMedicineName(row.getString("medicine_name"));
        treatmentData.setDosage(row.getString("dosage"));
        treatmentData.setTimes(row.getString("times"));
        treatmentData.setDoctor(row.getString("Doctor"));
        treatmentData.setDate(row.getString("date"));

        return treatmentData;
    }
}
