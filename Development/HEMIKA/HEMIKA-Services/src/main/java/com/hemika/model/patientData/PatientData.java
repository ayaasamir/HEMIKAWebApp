package com.hemika.model.patientData;

public class PatientData {

    private String name;
    private String age;
    private String status;

    public PatientData() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PatientData{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
