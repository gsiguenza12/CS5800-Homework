package com.company;

class Meal {
    private String carbs;
    private String proteins;
    private String fats;
    private FactoryCreator factoryCreator = FactoryCreator.getInstance();


    public String getCarbs() {
        return carbs;
    }

    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }

    public String getProteins() {
        return proteins;
    }

    public void setProteins(String proteins) {
        this.proteins = proteins;
    }

    public String getFats() {
        return fats;
    }

    public void setFats(String fats) {
        this.fats = fats;
    }

    public Meal(Customer customer) {
        Macronutrient carb = factoryCreator.getMacronutrient("carb", customer.getDietPlan());
        Macronutrient protein = factoryCreator.getMacronutrient("protein", customer.getDietPlan());
        Macronutrient fat = factoryCreator.getMacronutrient("fat", customer.getDietPlan());
        carbs = carb.produce();
//        System.out.println(carbs);
        proteins = protein.produce();
        fats = fat.produce();
        setCarbs(carbs);
        setProteins(proteins);
        setFats(fats);
    }

    @Override
    public String toString() {
        return "Carbs: " + carbs + ", Protein: " + proteins + ", Fats: " + fats;
    }

}