package com.hemika.model.rm;

import com.hemika.model.UserTypeVtoData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTypeVtoDataRM implements RowMapper<UserTypeVtoData> {


    @Override
    public UserTypeVtoData mapRow(ResultSet resultSet, int i) throws SQLException {

        UserTypeVtoData userType = new UserTypeVtoData();
        userType.setId(resultSet.getInt("id"));
        userType.setLabelEN(resultSet.getString("label_en"));
        return userType;
    }
}
