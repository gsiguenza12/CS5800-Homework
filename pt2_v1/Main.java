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

//        FactoryCreator factory = FactoryCreator.getInstance();
//        Macronutrient carb = factory.getMacronutrient("carb", customer1.getDietPlan());
//        String result = carb.produce();
//        System.out.println(result);
        Meal meal1 = new Meal(customer1);
        System.out.println("Customer: " + customer1.getName() + " Diet: " + customer1.getDietPlan() +  " Meal recommendation: " + meal1);
        Meal meal2 = new Meal(customer2);
        System.out.println("Customer: " + customer2.getName() + " Diet: " + customer2.getDietPlan() +  " Meal recommendation: " + meal2);
        Meal meal3 = new Meal(customer3);
        System.out.println("Customer: " + customer3.getName() + " Diet: " + customer3.getDietPlan() +  " Meal recommendation: " + meal3);
        Meal meal4 = new Meal(customer4);
        System.out.println("Customer: " + customer4.getName() + " Diet: " + customer4.getDietPlan() +  " Meal recommendation: " + meal4);
        Meal meal5 = new Meal(customer5);
        System.out.println("Customer: " + customer5.getName() + " Diet: " + customer5.getDietPlan() +  " Meal recommendation: " + meal5);
        Meal meal6 = new Meal(customer6);
        System.out.println("Customer: " + customer6.getName() + " Diet: " + customer6.getDietPlan() +  " Meal recommendation: " + meal6);
    }
}
