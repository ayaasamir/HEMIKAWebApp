package com.hemika.model.rm;

import com.hemika.model.DepartmentVtoData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentTypeVtoDataRM implements RowMapper<DepartmentVtoData> {
@Override
    public DepartmentVtoData mapRow(ResultSet resultSet, int i) throws SQLException {
       DepartmentVtoData DepartType = new DepartmentVtoData();
        DepartType.setId(resultSet.getInt("id"));
        DepartType.setDepartName(resultSet.getString("name"));
        return DepartType;
    }

}

