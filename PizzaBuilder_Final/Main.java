package com.company;

/***
 * You will create a pizza chain, Pizza Hut. When pizza’s are created they have many possible toppings
 * and to keep the creation simple for the user you will use the BUILDER design pattern to allow the user
 * to clearly understand which topping will be selected.
 */

public class Main {
    public static void main(String[] args) {
        PizzaDirector director = new PizzaDirector(new PizzaHutPizzaBuilder("Large")
                .addPepperoni()
                .addMushrooms()
                .addExtraCheese());

        Pizza pizzaHut = director.construct();
        pizzaHut.eat();

        director.setBuilder(new LittleCaesarsPizzaBuilder("Medium")
                .addBacon()
                .addOnions()
                .addExtraCheese()
                .addPeppers()
                .addChicken()
                .addOlives());

        Pizza littleCaesars = director.construct();
        littleCaesars.eat();

        director.setBuilder(new DominosPizzaBuilder("Small")
                .addSausage()
                .addBacon());

        Pizza dominos = director.construct();
        dominos.eat();
    }
}