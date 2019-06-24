package com.hemika.repository;

import com.hemika.model.DepartmentVtoData;
import com.hemika.model.HospitalNameVtoData;
import com.hemika.model.SpecializationVtoData;
import com.hemika.model.UserTypeVtoData;
import com.hemika.model.rm.DepartmentTypeVtoDataRM;
import com.hemika.model.rm.HospitalNameVtoDataRM;
import com.hemika.model.rm.SpecializationVtoDataRM;
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
        String sql = "SELECT `id` , `label_en` FROM mydb.role_t";
        List<UserTypeVtoData> roleType = this.jdbcTemplate.query(sql,
                new UserTypeVtoDataRM());
        return roleType;
    }
    public List<DepartmentVtoData> findDepartmentType() {
        String sql = "SELECT `id` , `name`  FROM  mydb.department_t GROUP BY id";
        List<DepartmentVtoData> departType = this.jdbcTemplate.query(sql,
                new DepartmentTypeVtoDataRM());
        return departType;
    }
    public List<SpecializationVtoData> findSpecializationName() {
        String sql = "SELECT `id` , `specialization_name` FROM  mydb.specialization_t GROUP BY id";
        List<SpecializationVtoData> specialization = this.jdbcTemplate.query(sql,
                new SpecializationVtoDataRM());
        return specialization;
    }

    public List<HospitalNameVtoData> findHospitalName() {
        String sql = "SELECT `id` , `name` FROM  mydb.hospital_t GROUP BY id";
        List<HospitalNameVtoData> hospitalName = this.jdbcTemplate.query(sql,
                new HospitalNameVtoDataRM());
        return hospitalName;
    }


}
