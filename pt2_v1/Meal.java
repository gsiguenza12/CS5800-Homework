package com.company;

class Meal {
    private String carbs;
    private String protein;
    private String fats;

    public Meal(String carbs, String protein, String fats) {
        this.carbs = carbs;
        this.protein = protein;
        this.fats = fats;
    }

    @Override
    public String toString() {
        return "Carbs: " + carbs + ", Protein: " + protein + ", Fats: " + fats;
    }

}