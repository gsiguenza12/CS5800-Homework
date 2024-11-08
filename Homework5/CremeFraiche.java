package com.company;

/**
 * heavy cream thickened and slightly soured with buttermilk
 */
public class CremeFraiche extends ToppingDecorator{
    CremeFraiche(FoodItem decoratedFoodItem){
        super(decoratedFoodItem,1.20);
    }

    @Override
    public String getDescription() {
        return decoratedFoodItem.getDescription() + ", Creme Fraiche";
    }

}
