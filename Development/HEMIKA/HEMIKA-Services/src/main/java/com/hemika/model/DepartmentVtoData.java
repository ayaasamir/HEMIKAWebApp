package com.hemika.model;

public class DepartmentVtoData {
    private int id;
    private String name;

    public DepartmentVtoData() { }

    public int getId() { return id; }

    public String getName() { return name; }

    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "DepartmentVtoData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
