package com.company;

/**
 *
 */
public class Customer {
    public Customer(String name, String dietPlan) {
        this.name = name;
        this.dietPlan = dietPlan;
    }

    private String name;
    private String dietPlan;
    private Meal meal;

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDietPlan() {
        return dietPlan;
    }

    public void setDietPlan(String dietPlan) {
        this.dietPlan = dietPlan;
    }
}
