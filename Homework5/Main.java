package com.company;

public class Main {

    /**
     * Implement this system using the decorator design pattern, and test it by creating some food items,
     * adding toppings, creating an order, and applying a loyalty discount in the driver program.
     * @param args
     */
    public static void main(String[] args) {
        Customer customer1 = new Customer("John", 105);
        Customer customer2 = new Customer("Stan DARSH", 500);

        Order order1 = new Order(customer1);

	    FoodItem hotdog = new Hotdog();
        FoodItem bangus = new Bangus();

        hotdog = new Cheese(hotdog);
        System.out.println(hotdog);

        order1.addFoodItem(hotdog);
//        order1.addFoodItem(bangus);


        order1.printOrderDetails();

        Discount discount = new LoyaltyDiscount(customer1);
        order1.setDiscount(discount);

        order1.printOrderDetails();
    }
}
