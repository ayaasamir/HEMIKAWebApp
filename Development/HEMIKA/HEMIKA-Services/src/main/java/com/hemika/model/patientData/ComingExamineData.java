package com.hemika.model.patientData;

public class ComingExamineData {
    private String comingDate;
    private String temperature;
    private String heartBeats;
    private String highBP;
    private String lowBP;

    public ComingExamineData() {
    }

    public String getComingDate() {
        return comingDate;
    }

    public void setComingDate(String comingDate) {
        this.comingDate = comingDate;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHeartBeats() {
        return heartBeats;
    }

    public void setHeartBeats(String heartBeats) {
        this.heartBeats = heartBeats;
    }

    public String getHighBP() {
        return highBP;
    }

    public void setHighBP(String highBP) {
        this.highBP = highBP;
    }

    public String getLowBP() {
        return lowBP;
    }

    public void setLowBP(String lowBP) {
        this.lowBP = lowBP;
    }

    @Override
    public String toString() {
        return "ComingExamineData{" +
                "comingDate='" + comingDate + '\'' +
                ", temperature='" + temperature + '\'' +
                ", heartBeats='" + heartBeats + '\'' +
                ", highBP='" + highBP + '\'' +
                ", lowBP='" + lowBP + '\'' +
                '}';
    }
}
