package com.hemika.repository;
import com.hemika.model.DoctorDtoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DocDetailsRep {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DocDetailsRep(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public void insertNewDoctor(DoctorDtoData data) {
        String sql = "insert into doctors (department,mobile,specialization," +
                ",grade_year,email) values (?,?,?,?,?)";
        this.jdbcTemplate.update(sql, data.getDepartment(), data.getMobile(),
                data.getSpecialization(), data.getGrade_year(),
                data.getEmail()
        );


    }
}
