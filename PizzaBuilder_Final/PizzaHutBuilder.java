package com.company;

class PizzaHutPizzaBuilder extends PizzaBuilder {
    public PizzaHutPizzaBuilder(String size) {
        super(size, "Pizza Hut");
    }

    @Override
    public Pizza build() {
        return new Pizza(this);
    }
}

