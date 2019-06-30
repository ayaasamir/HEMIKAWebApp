package com.hemika.model;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Service

public class createVisitorVTORM implements RowMapper {
    @Override
    public patientListVTO mapRow(ResultSet rs, int rowIndex) throws SQLException {
        patientListVTO data = new patientListVTO();
        data.setPatientName(rs.getString("fullname"));
        System.out.println(data);
        return data;
    }

}
