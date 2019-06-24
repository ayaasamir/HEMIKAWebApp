package com.hemika.repository;

import com.hemika.model.RobotDtoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CreateRobotRep {
    //private RobotDtoData robotDtoData;
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public CreateRobotRep(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}
    public void insertNewRobot(RobotDtoData data){
        String sql = "INSERT INTO mydb.robot_t (robot_name,location_X,location_Y,hospital_t_id) values(?,?,?,?)";

       this.jdbcTemplate.update(sql, data.getRobotName(), data.getLocation_X(),
                data.getLocation_Y(),data.getHospitalID()
       );
    }

}

