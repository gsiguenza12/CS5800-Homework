package com.company;

public class Cheese extends ToppingDecorator{
    Cheese(FoodItem decoratedFoodItem){
        super(decoratedFoodItem,0.50);
    }

    @Override
    public String getDescription() {
        return decoratedFoodItem.getDescription() + ", Cheese";
    }

}
