package com.hemika.model;

public class DepartmentVtoData {
    private int id;
    private String departName;

    public DepartmentVtoData() { }

    public int getId() { return id; }

    public String getDepartName() {
        return departName;
    }

    public void setId(int id) { this.id = id; }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    @Override
    public String toString() {
        return "DepartmentVtoData{" +
                "id=" + id +
                ", departName='" + departName + '\'' +
                '}';
    }
}
