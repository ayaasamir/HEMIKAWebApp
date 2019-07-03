package com.hemika.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class patientListVTORM implements RowMapper<patientListVTO> {
    @Override
    public patientListVTO mapRow(ResultSet rs, int rowIndex) throws SQLException {
        patientListVTO data = new patientListVTO();
        data.setStartDate(rs.getString("date"));
        data.setPatientStatus(rs.getString("status"));
        data.setPatientName(rs.getString("fullname"));
        data.setNationalId(rs.getString("national_Id"));
        System.out.println(data);
        return data;
    }
}
