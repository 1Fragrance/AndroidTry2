package com.example.androidtry2.models;

public class Product {
    private int id;
    private String name;
    private double cost;
    private int typeId;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
