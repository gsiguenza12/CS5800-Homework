package com.company;

// class representing a customer
class Customer {
    private String name;
    private int loyaltyPoints;

    public Customer(String name, int loyaltyPoints) {
        setName(name);
        setLoyaltyPoints(loyaltyPoints);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}