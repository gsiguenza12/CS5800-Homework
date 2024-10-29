package com.company;

import java.util.List;

public class Pizza {
    private final String size;
    private final String chainName;
    private final List<String> toppings;

    public Pizza(PizzaBuilder builder) {
        this.size = builder.getSize();
        this.chainName = builder.getChainName();
        this.toppings = builder.getToppings();
    }

    @Override
    public String toString() {
        return "Pizza [chain=" + chainName + ", size=" + size + ", toppings=" + toppings + "]";
    }

    public void eat() {
        System.out.println("Eating a pizza from: " + chainName);
        System.out.println("Size: " + this.size);
        System.out.println("Toppings: " + String.join(", ", toppings));
    }
}
