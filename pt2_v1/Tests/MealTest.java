package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MealTest {

    @Test
    public void testSetCarbs() {
        Customer customer = new Customer("John Doe", "No Restriction");

        FactoryCreator factoryCreator = FactoryCreator.getInstance();
        Macronutrient carb = factoryCreator.getMacronutrient("carb", "No Restriction");

        Meal meal = new Meal(customer);

        meal.setCarbs("Pasta");
        assertEquals("Pasta", meal.getCarbs());
    }

    @Test
    public void testSetProteins() {
        Customer customer = new Customer("John Doe", "No Restriction");

        Meal meal = new Meal(customer);

        meal.setProteins("Beef");
        assertEquals("Beef", meal.getProteins());
    }

    @Test
    public void testSetFats() {
        Customer customer = new Customer("John Doe", "No Restriction");

        FactoryCreator factoryCreator = FactoryCreator.getInstance();
        Macronutrient fat = factoryCreator.getMacronutrient("fat", "No Restriction");

        Meal meal = new Meal(customer);

        meal.setFats("Peanuts");
        assertEquals("Peanuts", meal.getFats());
    }

}

