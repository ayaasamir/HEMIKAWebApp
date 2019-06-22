package com.hemika.model.rm;

import com.hemika.model.UserData;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserTypeRM implements RowMapper<UserData> {
    @Override
    public UserData mapRow(ResultSet resultSet, int i) throws SQLException {

        UserData userData = new UserData();
        userData.setId(resultSet.getInt("id"));
        userData.setLabel_en(resultSet.getString("label_en"));
        return userData;
    }
}
