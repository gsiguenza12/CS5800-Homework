package com.company;

public class Bacon extends ToppingDecorator{
    Bacon(FoodItem decoratedFoodItem){
        super(decoratedFoodItem,0.75);
    }

    @Override
    public String getDescription(){
        return decoratedFoodItem.getDescription() + ", Bacon";
    }

}
