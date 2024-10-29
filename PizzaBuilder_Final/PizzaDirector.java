package com.company;

public class PizzaDirector {
    private PizzaBuilder builder;

    public PizzaDirector(PizzaBuilder builder) {
        this.builder = builder;
    }

    public Pizza construct() {
        return builder.build();
    }

    public PizzaDirector setBuilder(PizzaBuilder builder) {
        this.builder = builder;
        return this;
    }
}