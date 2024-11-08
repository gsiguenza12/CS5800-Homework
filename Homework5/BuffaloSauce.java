package com.company;

/**
 * Buffalo sauce duh
 */
public class BuffaloSauce extends ToppingDecorator{

        BuffaloSauce(FoodItem decoratedFoodItem){
            super(decoratedFoodItem, 0.75);
        }

        @Override
        public String getDescription() {
            return decoratedFoodItem.getDescription() + ", Buffalo Sauce";
        }

}
