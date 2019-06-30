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
        String sql = "insert into mydb.doctor_t (user_t_national_id,graduation_year,experience," +
                "department_t_id,specialization_t_id) values (?,?,?,?,?)";
        this.jdbcTemplate.update(sql, data.getNationalID(), data.getGrade_year(),
                data.getExperience(), data.getDepartment(),
                data.getSpecialization()
        );


    }
}
