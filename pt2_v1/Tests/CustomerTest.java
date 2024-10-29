package com.company;
import org.junit.Test;


import static org.junit.Assert.*;

public class CustomerTest {
    private Customer customer;


    @Test
    public void testConstructor() {
        customer = new Customer("John Doe", "No Restriction");
        System.out.println("Testing constructor...");
        assertEquals("John Doe", customer.getName());
        assertEquals("No Restriction", customer.getDietPlan());
        assertNull(customer.getMeal());
    }

    @Test
    public void testSetName() {
        customer = new Customer("Jane Doe", "No Restriction");
        System.out.println("Testing setName...");
        customer.setName("Jane Doe");
        assertEquals("Jane Doe", customer.getName());
    }

    @Test
    public void testSetDietPlan() {
        customer = new Customer("John Doe", "No Restriction");
        System.out.println("Testing setDietPlan...");
        customer.setDietPlan("Vegan");
        assertEquals("Vegan", customer.getDietPlan());
    }
}