package com.hemika.model;

public class SpecializationVtoData {
    private int id;
    private String specialName;

    public SpecializationVtoData() {
    }

    public int getId() {
        return id;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    @Override
    public String toString() {
        return "SpecializationVtoData{" +
                "id=" + id +
                ", specialName='" + specialName + '\'' +
                '}';
    }
}
