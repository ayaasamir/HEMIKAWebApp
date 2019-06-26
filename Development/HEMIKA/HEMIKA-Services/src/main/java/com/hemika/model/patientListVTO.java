package com.hemika.model;

import java.io.Serializable;

public class patientListVTO implements Serializable {
    private String patientName;
    private String patientStatus;
    private String startDate;
    private String endDate;
    private String lastCheck;

    public patientListVTO() {
    }

    public String getPatientName() {
        return patientName;
    }
    public String getEndDate(){return endDate;}
    public void setEndDate(String end_date){this.endDate=endDate;}

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(String patientStatus) {
        this.patientStatus = patientStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getLastCheck() {
        return lastCheck;
    }

    public void setLastCheck(String lastCheck) {
        this.lastCheck = lastCheck;
    }
}
