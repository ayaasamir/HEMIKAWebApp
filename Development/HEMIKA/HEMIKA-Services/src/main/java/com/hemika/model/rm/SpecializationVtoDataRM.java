package com.hemika.model.rm;

import com.hemika.model.SpecializationVtoData;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecializationVtoDataRM implements RowMapper<SpecializationVtoData> {
      @Override
        public SpecializationVtoData mapRow(ResultSet resultSet, int i) throws SQLException {
          SpecializationVtoData specialization = new SpecializationVtoData();
          specialization.setId(resultSet.getInt("id"));
          specialization.setName(resultSet.getString("specialization_name"));
            return specialization;
        }

    }
