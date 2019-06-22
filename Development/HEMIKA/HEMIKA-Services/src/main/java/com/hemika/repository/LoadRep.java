package com.hemika.repository;

import com.hemika.model.UserTypeVtoData;
import com.hemika.model.rm.UserTypeVtoDataRM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoadRep {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public LoadRep(JdbcTemplate jdbcTemplate){this.jdbcTemplate =jdbcTemplate;}

//    public List<UserTypeVtoData> findUserType() {
//        String sql = "SELECT id , label_en FROM user_type";
//        List<UserTypeVtoData> userType = this.jdbcTemplate.query(sql,
//                new UserTypeVtoDataRM());
//        return userType;
//    }

    public List<UserTypeVtoData> findUserType() {
        String sql = "SELECT id , label_en FROM role_t";
        List<UserTypeVtoData> roleType = this.jdbcTemplate.query(sql,
                new UserTypeVtoDataRM());
        return roleType;
    }


}
