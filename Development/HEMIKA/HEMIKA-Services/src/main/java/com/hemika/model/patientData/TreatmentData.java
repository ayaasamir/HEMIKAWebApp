package com.hemika.model.patientData;

public class TreatmentData {

    private String comment;
    private String diagnosis;
    private String medicineName;
    private String dosage;
    private String times;
    private String doctor;
    private String date;

    public TreatmentData() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TreatmentData{" +
                "comment='" + comment + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", dosage='" + dosage + '\'' +
                ", times='" + times + '\'' +
                ", doctor='" + doctor + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
