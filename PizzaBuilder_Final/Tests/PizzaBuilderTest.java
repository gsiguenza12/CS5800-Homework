package com.company;
import org.junit.Test;
import static org.junit.Assert.*;

// Test class for PizzaBuilder
public class PizzaBuilderTest {

    @Test
    public void testAddPepperoni() {
        PizzaBuilder builder = new PizzaHutPizzaBuilder("Large");
        builder.addPepperoni();
        assertTrue(builder.getToppings().contains("Pepperoni"));
    }

    @Test
    public void testAddSausage() {
        PizzaBuilder builder = new LittleCaesarsPizzaBuilder("Medium");
        builder.addSausage();
        assertTrue(builder.getToppings().contains("Sausage"));
    }

    @Test
    public void testAddMushrooms() {
        PizzaBuilder builder = new DominosPizzaBuilder("Small");
        builder.addMushrooms();
        assertTrue(builder.getToppings().contains("Mushrooms"));
    }

    @Test
    public void testAddBacon() {
        PizzaBuilder builder = new PizzaHutPizzaBuilder("Large");
        builder.addBacon();
        assertTrue(builder.getToppings().contains("Bacon"));
    }

    @Test
    public void testAddOnions() {
        PizzaBuilder builder = new LittleCaesarsPizzaBuilder("Medium");
        builder.addOnions();
        assertTrue(builder.getToppings().contains("Onions"));
    }

    @Test
    public void testAddExtraCheese() {
        PizzaBuilder builder = new DominosPizzaBuilder("Small");
        builder.addExtraCheese();
        assertTrue(builder.getToppings().contains("Extra Cheese"));
    }

    @Test
    public void testAddPeppers() {
        PizzaBuilder builder = new PizzaHutPizzaBuilder("Large");
        builder.addPeppers();
        assertTrue(builder.getToppings().contains("Peppers"));
    }

    @Test
    public void testAddChicken() {
        PizzaBuilder builder = new LittleCaesarsPizzaBuilder("Medium");
        builder.addChicken();
        assertTrue(builder.getToppings().contains("Chicken"));
    }

    @Test
    public void testAddOlives() {
        PizzaBuilder builder = new DominosPizzaBuilder("Small");
        builder.addOlives();
        assertTrue(builder.getToppings().contains("Olives"));
    }

    @Test
    public void testAddSpinach() {
        PizzaBuilder builder = new PizzaHutPizzaBuilder("Large");
        builder.addSpinach();
        assertTrue(builder.getToppings().contains("Spinach"));
    }

    @Test
    public void testAddTomatoAndBasil() {
        PizzaBuilder builder = new LittleCaesarsPizzaBuilder("Medium");
        builder.addTomatoAndBasil();
        assertTrue(builder.getToppings().contains("Tomato and Basil"));
    }

    @Test
    public void testAddBeef() {
        PizzaBuilder builder = new DominosPizzaBuilder("Small");
        builder.addBeef();
        assertTrue(builder.getToppings().contains("Beef"));
    }

    @Test
    public void testAddHam() {
        PizzaBuilder builder = new PizzaHutPizzaBuilder("Large");
        builder.addHam();
        assertTrue(builder.getToppings().contains("Ham"));
    }

    @Test
    public void testAddPesto() {
        PizzaBuilder builder = new LittleCaesarsPizzaBuilder("Medium");
        builder.addPesto();
        assertTrue(builder.getToppings().contains("Pesto"));
    }

    @Test
    public void testAddSpicyPork() {
        PizzaBuilder builder = new DominosPizzaBuilder("Small");
        builder.addSpicyPork();
        assertTrue(builder.getToppings().contains("Spicy Pork"));
    }

    @Test
    public void testAddHamAndPineapple() {
        PizzaBuilder builder = new PizzaHutPizzaBuilder("Large");
        builder.addHamAndPineapple();
        assertTrue(builder.getToppings().contains("Ham and Pineapple"));
    }

    @Test
    public void testPizzaBuild() {
        PizzaBuilder builder = new PizzaHutPizzaBuilder("Large")
                .addPepperoni()
                .addMushrooms()
                .addExtraCheese();
        Pizza pizza = builder.build();
        assertEquals("Pizza Hut", pizza.getChainName());
        assertEquals("Large", pizza.getSize());
        assertTrue(pizza.getToppings().contains("Pepperoni"));
        assertTrue(pizza.getToppings().contains("Mushrooms"));
        assertTrue(pizza.getToppings().contains("Extra Cheese"));
    }
}
