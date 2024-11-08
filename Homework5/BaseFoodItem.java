package com.company;

public class BaseFoodItem implements FoodItem{

    protected String description;
    protected double cost;

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return "BaseFoodItem{" +
                "description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
