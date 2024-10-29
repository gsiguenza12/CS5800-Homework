package com.company;

/**
 * Create 6 customers in your driver program to show all the various diet plans.
 * Make sure your system randomly chooses food items in each category that meets
 * the customers’ diet restrictions.
 *
 * NOTE: The driver program will have 6 customers, and each should expect a Meal
 * which will have one item from Carbs, Protein and Fats.
 */
public class Main {

    public static void main(String[] args) {
        Customer customer1 = new Customer("john", "no restriction");
        Customer customer2 = new Customer("jane", "Paleo");
        Customer customer3 = new Customer("christian", "Vegan");
        Customer customer4 = new Customer("gabe", "no restriction");
        Customer customer5 = new Customer("riley", "Nut Allergy");
        Customer customer6 = new Customer("sally", "Paleo");

        FactoryCreator factory = FactoryCreator.getInstance();
        Macronutrient carb = factory.getMacronutrient("carb", customer1.getDietPlan());
        String result = carb.produce();
        System.out.println(result);

    }
}
