package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class PizzaBuilder {
    private String size;
    private String chainName;
    private List<String> toppings = new ArrayList<>();

    public PizzaBuilder() {
    }

    public PizzaBuilder(String size, String chainName) {
        this.size = size;
        this.chainName = chainName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public PizzaBuilder addPepperoni() {
        this.toppings.add("Pepperoni");
        return this;
    }

    public PizzaBuilder addSausage() {
        this.toppings.add("Sausage");
        return this;
    }

    public PizzaBuilder addMushrooms() {
        this.toppings.add("Mushrooms");
        return this;
    }

    public PizzaBuilder addBacon() {
        this.toppings.add("Bacon");
        return this;
    }

    public PizzaBuilder addOnions() {
        this.toppings.add("Onions");
        return this;
    }

    public PizzaBuilder addExtraCheese() {
        this.toppings.add("Extra Cheese");
        return this;
    }

    public PizzaBuilder addPeppers() {
        this.toppings.add("Peppers");
        return this;
    }

    public PizzaBuilder addChicken() {
        this.toppings.add("Chicken");
        return this;
    }

    public PizzaBuilder addOlives() {
        this.toppings.add("Olives");
        return this;
    }

    public PizzaBuilder addSpinach() {
        this.toppings.add("Spinach");
        return this;
    }

    public PizzaBuilder addTomatoAndBasil() {
        this.toppings.add("Tomato and Basil");
        return this;
    }

    public PizzaBuilder addBeef() {
        this.toppings.add("Beef");
        return this;
    }

    public PizzaBuilder addHam() {
        this.toppings.add("Ham");
        return this;
    }

    public PizzaBuilder addPesto() {
        this.toppings.add("Pesto");
        return this;
    }

    public PizzaBuilder addSpicyPork() {
        this.toppings.add("Spicy Pork");
        return this;
    }

    public PizzaBuilder addHamAndPineapple() {
        this.toppings.add("Ham and Pineapple");
        return this;
    }

    public abstract Pizza build();
}
