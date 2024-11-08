package com.company;

public abstract class ToppingDecorator implements FoodItem{
    protected FoodItem decoratedFoodItem;
    protected double toppingCost;

    public ToppingDecorator(FoodItem decoratedFoodItem, double toppingCost) {
        this.decoratedFoodItem = decoratedFoodItem; this.toppingCost = toppingCost;
    }

    @Override public String getDescription() {
        return decoratedFoodItem.getDescription();
    }

    @Override public double getCost() {
        return decoratedFoodItem.getCost() + toppingCost;
    }
    @Override public String toString() {
        return getDescription() + ", total cost: " + getCost();
    }


}
