package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToppingsDecoratorTest {

    private FoodItem burger;

    @BeforeEach
    void setUp() {
        burger = new Burger();
    }

    @Test
    void testGetDescription() {
        // Test that the description is calculated correctly for CremeFraiche
        CremeFraiche cremeFraiche = new CremeFraiche(burger);
        assertEquals("Burger, Creme Fraiche", cremeFraiche.getDescription());

        // Test that the description is inherited from the decorated food item
        Cheese withCheese = new Cheese(cremeFraiche);
        assertEquals("Burger, Creme Fraiche, Cheese", withCheese.getDescription());
    }

    @Test
    void testGetCost() {
        CremeFraiche cremeFraiche = new CremeFraiche(burger);
        // Test that the cost is calculated correctly for CremeFraiche
        double expectedCost = cremeFraiche.getCost();
        assertEquals(expectedCost, new CremeFraiche(burger).getCost(), 0.01);

        // Test that the cost is inherited from the decorated food item
        double expectedTotalCost = new Cheese(cremeFraiche).getCost();
        assertEquals(expectedTotalCost, new Cheese(new CremeFraiche(burger)).getCost(), 0.01);
    }

    @Test
    void testToString() {
        // Test that the toString method returns the correct string for CremeFraiche
        FoodItem burger = new Burger();
        String expectedString = "Burger, Creme Fraiche, total cost: " + (burger.getCost() + 1.20);
        assertEquals(expectedString, new CremeFraiche(burger).toString());
    }
}

