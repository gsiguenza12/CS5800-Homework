package com.company;

public class LoyaltyDiscount extends Discount{
    private int loyaltyPoints = 0;

    LoyaltyDiscount(Customer customer){
        this.loyaltyPoints = customer.getLoyaltyPoints();
    }

    @Override
    double applyDiscount(double totalCost) {
        double discountPercentage;
        if(loyaltyPoints >= 30000){
            discountPercentage = 30.0; // 30% discount for 10,000 or more points
        }
        else if (loyaltyPoints >= 1000) {
            discountPercentage = 20.0; // 20% discount for 1000 or more points
        } else if (loyaltyPoints >= 500) {
            discountPercentage = 15.0; // 15% discount for 500-999 points
        } else if (loyaltyPoints >= 200) {
            discountPercentage = 10.0; // 10% discount for 200-499 points
        } else if (loyaltyPoints >= 100) {
            discountPercentage = 5.0; // 5% discount for 100-199 points
        } else {
            discountPercentage = 0.0; // No discount for less than 100 points
        }
        return totalCost * (1 - discountPercentage / 100);
    }

}
