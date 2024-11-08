package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Comparator;


import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    private Customer customer1, customer2;
    private FoodItem foodItem1, foodItem2, foodItem3, foodItem4, foodItem5, foodItem6;
    private Discount discount1, discount2;

    @BeforeEach
    void setUp() {
        customer1 = new Customer("John Doe", 10);
        customer2 = new Customer("Joanna Mitchell", 500);
        foodItem1 = new Burger();
        foodItem2 = new Fries();
        foodItem3 = new Bangus();
        foodItem4 = new Hotdog();
        foodItem5 = new BeefWellington();
        foodItem6 = new Churros();

        discount1 = new LoyaltyDiscount(customer1); // 20% discount
        discount2 = new LoyaltyDiscount(customer1); // 3% discount
    }

    @AfterEach
    void tearDown() {
        // No specific cleanup needed for this test class
    }

    @Test
    void addFoodItem() {
        Order order = new Order(customer1);
        order.addFoodItem(foodItem1);
        order.addFoodItem(foodItem2);
        assertEquals(2, order.getFoodItems().size());
    }

    @Test
    void DecorateWithAllToppings(){
        foodItem1 = new CremeFraiche(foodItem1);
        foodItem1 = new Cheese(foodItem1);
        foodItem1 = new BuffaloSauce(foodItem1);
        foodItem1 = new Bacon(foodItem1);
        foodItem1 = new Chili(foodItem1);
        System.out.println(foodItem1);
    }

    @Test
    void setDiscount() {
        Order order = new Order(customer1);
        Discount discount = new LoyaltyDiscount(customer1); // 20% discount
        order.setDiscount(discount);
        assertEquals(discount, order.getDiscount());
    }

    @Test
    void getTotalCost() {
        Order order = new Order(customer1);
        FoodItem foodItem = new Burger();
        order.addFoodItem(foodItem);
        double expectedTotalCost = 8.95;
        assertEquals(expectedTotalCost, order.getTotalCost(), 0.01); // allow for slight floating point error
    }

    @Test
    void printOrderDetails() {
        Order order = new Order(customer1);
        FoodItem foodItem = new Burger();
        order.addFoodItem(foodItem);
//        order.printOrderDetails();
        System.out.println(order);

        // Assert that the output matches the expected string
        String expectedOutput = "Order{foodItems=[BaseFoodItem{description='Burger', cost=8.95}], discount=null, customer=Customer{name='John Doe', loyaltyPoints=10}}";
        assertEquals(expectedOutput, order.toString());
    }

    @Test
    void testFoodItemToString(){
        FoodItem foodItem = new Burger();
        String expectedOutput = "BaseFoodItem{description='Burger', cost=8.95}";
        assertEquals(expectedOutput, foodItem.toString());
    }
    @Test
    void applyDiscount() {
        Order order = new Order(customer1);
        FoodItem foodItem = new Burger();
        order.addFoodItem(foodItem);
        customer1.setLoyaltyPoints(1000);
        Discount discount = new LoyaltyDiscount(customer1); // 20% discount
        order.setDiscount(discount);
        System.out.println(customer1);
        double expectedTotalCost = 7.16; // after applying 20% discount
        assertEquals(expectedTotalCost, order.getTotalCost(), 0.01); // allow for slight floating point error
    }

}
