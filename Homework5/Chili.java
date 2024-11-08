package com.company;

/**
 * Specialty Chili made with Tri-tip Steak cooked for 5 hours
 */
public class Chili extends ToppingDecorator{
    Chili(FoodItem decoratedFoodItem){
        super(decoratedFoodItem, 5.99);
    }

    @Override
    public String getDescription() {
        return decoratedFoodItem.getDescription() + ", Chili";
    }

}
