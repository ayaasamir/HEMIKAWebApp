package com.hemika.model;

public class UserData {
    private int id;
    private String label_en;
    public UserData() {
    }

    public void setLabel_en(String label_en) {
        this.label_en = label_en;
    }

    public String getLabel_en() {
        return label_en;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", label_en='" + label_en + '\'' +
                '}';
    }
}
