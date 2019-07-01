package com.hemika.model.patientData.rm;

import com.hemika.model.patientData.ComingExamineData;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class PatientDataRM2 implements RowMapper<ComingExamineData> {


    @Override
    public ComingExamineData mapRow(ResultSet row, int i) throws SQLException {

        ComingExamineData comingExamineData = new ComingExamineData();
        comingExamineData.setComingDate(row.getString("coming_date"));
        comingExamineData.setTemperature(row.getString("temperature"));
        comingExamineData.setHeartBeats(row.getString("pulse"));
        comingExamineData.setHighBP(row.getString("high_bp"));
        comingExamineData.setLowBP(row.getString("low_bp"));

        return comingExamineData;
    }
}
