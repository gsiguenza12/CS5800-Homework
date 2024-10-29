package com.company;

class LittleCaesarsPizzaBuilder extends PizzaBuilder {
    public LittleCaesarsPizzaBuilder(String size) {
        super(size, "Little Caesars");
    }

    @Override
    public Pizza build() {
        return new Pizza(this);
    }
}
