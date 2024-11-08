package com.company;

import java.util.ArrayList;
import java.util.List;

// Class representing an order
class Order {
    private List<FoodItem> foodItems = new ArrayList<>();
    private Discount discount;
    private Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void addFoodItem(FoodItem foodItem) {
        foodItems.add(foodItem);
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Discount getDiscount() {
        return discount;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public double getTotalCost() {
        double totalCost = 0.0;
        for (FoodItem item : foodItems) {
            totalCost += item.getCost();
        }
        if (discount != null) {
            totalCost = discount.applyDiscount(totalCost);
        }
        return totalCost;
    }

    public void printOrderDetails() {
        System.out.println("Order for: " + customer.getName());
        System.out.println("Loyalty points: " + customer.getLoyaltyPoints());
        System.out.println("Total Cost: $" + getTotalCost());
    }

    @Override
    public String toString() {
        return "Order{" +
                "foodItems=" + foodItems +
                ", discount=" + discount +
                ", customer=" + customer +
                '}';
    }
}
