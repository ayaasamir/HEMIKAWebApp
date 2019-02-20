package com.hemika.repository;

import com.hemika.model.user.User;
import com.hemika.model.user.rm.UserRM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SecurityRep {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SecurityRep(JdbcTemplate Jdbc) {
        this.jdbcTemplate = Jdbc;
    }

    public User getUserByUserName(String userName) {
        String sql = "select * from users where user_name = ?;";
        RowMapper<User> rowMapper = new UserRM();
        User user = jdbcTemplate.queryForObject(sql, rowMapper, userName);
        return user;
    }
}