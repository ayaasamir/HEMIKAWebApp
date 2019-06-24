package com.hemika.model;

public class DoctorDtoData {
    private String nationalID;
    private int department;
    private int specialization;
    private String experience;
    private int grade_year;
    // private String personal_pic;

    public DoctorDtoData() { }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSpecialization(int specialization) {
        this.specialization = specialization;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setGrade_year(int grade_year) {
        this.grade_year = grade_year;
    }

    public String getNationalID() {
        return nationalID;
    }

    public int getDepartment() {
        return department;
    }

    public int getSpecialization() {
        return specialization;
    }

    public String getExperience() {
        return experience;
    }

    public int getGrade_year() {
        return grade_year;
    }

    @Override
    public String toString() {
        return "DoctorDtoData{" +
                "nationalID='" + nationalID + '\'' +
                ", department=" + department +
                ", specialization=" + specialization +
                ", experience='" + experience + '\'' +
                ", grade_year=" + grade_year +
                '}';
    }
}

