package com.hemika.model.patientData.rm;

import com.hemika.model.patientData.PatientData;
import com.hemika.model.user.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class PatientDataRM1 implements RowMapper<PatientData> {
    @Override
    public PatientData mapRow(ResultSet row, int i) throws SQLException {

        PatientData patientData = new PatientData();
        patientData.setName(row.getString("name"));
        patientData.setAge(row.getString("age"));
        patientData.setStatus(row.getString("status"));

        return patientData;
    }
}
