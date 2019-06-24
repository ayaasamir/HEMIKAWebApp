package com.hemika.model;

public class HospitalNameVtoData {
    private int id;
    private String name;

    public HospitalNameVtoData() { }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HospitalNameVtoData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
