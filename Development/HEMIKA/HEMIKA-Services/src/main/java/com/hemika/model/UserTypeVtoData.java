package com.hemika.model;

public class UserTypeVtoData {
    private int id;
    private String labelEN;

    public UserTypeVtoData() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabelEN() {
        return labelEN;
    }

    public void setLabelEN(String labelEN) {
        this.labelEN = labelEN;
    }

    @Override
    public String toString() {
        return "UserTypeVtoData{" +
                "id=" + id +
                ", labelEN='" + labelEN + '\'' +
                '}';
    }
}
