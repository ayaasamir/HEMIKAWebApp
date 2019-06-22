package com.hemika.model;

import java.io.Serializable;

public class VisitorDtoData implements Serializable {
    private String name;
    private String relation;
    private int id;

    public VisitorDtoData() { }

    public String getName() { return name; }

    public String getRelation() { return relation; }

    public int getId() { return id; }

    public void setName(String name) { this.name = name; }

    public void setRelation(String relation) { this.relation = relation; }

    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "VisitorDtoData{" +
                "name='" + name + '\'' +
                ", relation='" + relation + '\'' +
                ", id=" + id +
                '}';
    }
}
