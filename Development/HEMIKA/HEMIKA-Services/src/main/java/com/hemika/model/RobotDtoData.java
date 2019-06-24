package com.hemika.model;

public class RobotDtoData {
    private String robotName;
    private int location_X;
    private int location_Y;
    private int hospitalID;
    public RobotDtoData() {}

    public int getHospitalID() {
        return hospitalID;
    }



    public void setHospitalID(int hospitalID) {
        this.hospitalID = hospitalID;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    public void setLocation_X(int location_X) {
        this.location_X = location_X;
    }

    public void setLocation_Y(int location_Y) {
        this.location_Y = location_Y;
    }

    public String getRobotName() {
        return robotName;
    }

    public int getLocation_X() {
        return location_X;
    }

    public int getLocation_Y() {
        return location_Y;
    }

    @Override
    public String toString() {
        return "RobotDtoData{" +
                "robotName='" + robotName + '\'' +
                ", location_X=" + location_X +
                ", location_Y=" + location_Y +
                ", hospitalID=" + hospitalID +
                '}';
    }
}
