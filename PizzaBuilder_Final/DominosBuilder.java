package com.company;

class DominosPizzaBuilder extends PizzaBuilder {
    public DominosPizzaBuilder(String size) {
        super(size, "Dominos");
    }

    @Override
    public Pizza build() {
        return new Pizza(this);
    }
}

