package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// Test class for PizzaDirector
public class PizzaDirectorTest {

    @Test
    public void testPizzaConstruction() {
        // Test Pizza Hut construction
        PizzaBuilder pizzaHutBuilder = new PizzaHutPizzaBuilder("Large")
                .addPepperoni()
                .addMushrooms()
                .addExtraCheese();
        PizzaDirector director = new PizzaDirector(pizzaHutBuilder);
        Pizza pizzaHut = director.construct();
        assertEquals("Pizza Hut", pizzaHut.getChainName());
        assertEquals("Large", pizzaHut.getSize());
        assertTrue(pizzaHut.getToppings().contains("Pepperoni"));
        assertTrue(pizzaHut.getToppings().contains("Mushrooms"));
        assertTrue(pizzaHut.getToppings().contains("Extra Cheese"));

        // Test Little Caesars construction
        PizzaBuilder littleCaesarsBuilder = new LittleCaesarsPizzaBuilder("Medium")
                .addBacon()
                .addOnions()
                .addExtraCheese()
                .addPeppers()
                .addChicken()
                .addOlives();
        director.setBuilder(littleCaesarsBuilder);
        Pizza littleCaesars = director.construct();
        assertEquals("Little Caesars", littleCaesars.getChainName());
        assertEquals("Medium", littleCaesars.getSize());
        assertTrue(littleCaesars.getToppings().contains("Bacon"));
        assertTrue(littleCaesars.getToppings().contains("Onions"));
        assertTrue(littleCaesars.getToppings().contains("Extra Cheese"));
        assertTrue(littleCaesars.getToppings().contains("Peppers"));
        assertTrue(littleCaesars.getToppings().contains("Chicken"));
        assertTrue(littleCaesars.getToppings().contains("Olives"));

        // Test Dominos construction
        PizzaBuilder dominosBuilder = new DominosPizzaBuilder("Small")
                .addSausage()
                .addBacon();
        director.setBuilder(dominosBuilder);
        Pizza dominos = director.construct();
        assertEquals("Dominos", dominos.getChainName());
        assertEquals("Small", dominos.getSize());
        assertTrue(dominos.getToppings().contains("Sausage"));
        assertTrue(dominos.getToppings().contains("Bacon"));
    }
}