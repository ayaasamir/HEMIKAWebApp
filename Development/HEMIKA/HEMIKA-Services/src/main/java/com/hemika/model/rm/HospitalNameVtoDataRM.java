package com.hemika.model.rm;

import com.hemika.model.HospitalNameVtoData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalNameVtoDataRM implements RowMapper<HospitalNameVtoData> {
    @Override
    public HospitalNameVtoData mapRow(ResultSet resultSet, int i) throws SQLException {
        HospitalNameVtoData hospitalName = new HospitalNameVtoData();
        hospitalName.setId(resultSet.getInt("id"));
        hospitalName.setName(resultSet.getString("name"));
        return hospitalName;
    }




}
