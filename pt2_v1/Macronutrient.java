package com.company;

/**
 * Macronutrient should use an Abstract Factory to create the three Carbs,
 * Protein and Fats Factories to produce a meal
 */
public abstract class Macronutrient {
    abstract String produce();
}
