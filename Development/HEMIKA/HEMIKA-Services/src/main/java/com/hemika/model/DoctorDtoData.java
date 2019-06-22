package com.hemika.model;

public class DoctorDtoData {
    private String department;
    private int mobile;
    private String specialization;
    private int grade_year;
    private String email;
   // private String personal_pic;

    public DoctorDtoData() { }

    @Override
    public String toString() {
        return "DoctorDtoData{" +
                "department='" + department + '\'' +
                ", mobile=" + mobile +
                ", specialization='" + specialization + '\'' +
                ", grade_year=" + grade_year +
                ", email='" + email + '\'' +
                '}';
    }
//    @Override
//    public String toString() {
//        return "DoctorDtoData{" +
//                "department='" + department + '\'' +
//                ", mobile=" + mobile +
//                ", specialization='" + specialization + '\'' +
//                ", grade_year=" + grade_year +
//                ", email='" + email + '\'' +
//                ", personal_pic='" + personal_pic + '\'' +
//                '}';
//    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getGrade_year() {
        return grade_year;
    }

    public void setGrade_year(int grade_year) {
        this.grade_year = grade_year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getPersonal_pic() {
//        return personal_pic;
//    }

//    public void setPersonal_pic(String personal_pic) {
//        this.personal_pic = personal_pic;
//    }
}
