package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Customer customer1;

    @BeforeEach
    void setUp() {
        customer1 = new Customer("John Doe", 10);
    }

    @AfterEach
    void tearDown() {
        // no specific cleanup needed for this test class
    }


    @Test
    void setName() {
        String name = "Jane Doe";
        customer1.setName(name);
        assertEquals(name, customer1.getName());
    }

    @Test
    void getLoyaltyPoints() {
        int expectedLoyaltyPoints = 10;
        customer1.setLoyaltyPoints(expectedLoyaltyPoints);
        assertEquals(expectedLoyaltyPoints, customer1.getLoyaltyPoints());
    }

    @Test
    void setLoyaltyPoints() {
        int newLoyaltyPoints = 20;
        customer1.setLoyaltyPoints(newLoyaltyPoints);
        assertEquals(newLoyaltyPoints, customer1.getLoyaltyPoints());
    }

    @Test
    void getName() {
        String expectedName = "John Doe";
        assertEquals(expectedName, customer1.getName());
    }

    @Test
    void testToString() {
        // Test the toString method with different values
        Customer customer2 = new Customer("Jane Doe", 10);
        String expectedString = "Customer{" +
                "name='" + "Jane Doe" + '\'' +
                ", loyaltyPoints=" + 10 +
                '}';
        assertEquals(expectedString, customer2.toString());
    }
}