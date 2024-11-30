package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SnackTest {
    private Snack snack;

    @BeforeEach
    public void setUp() {
        snack = new Snack("Chips", 1.5, 10);
    }

    @Test
    public void testGetName() {
        assertEquals("Chips", snack.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(1.5, snack.getPrice());
    }

    @Test
    public void testGetQuantity() {
        assertEquals(10, snack.getQuantity());
    }

    @Test
    public void testDispense() {
        snack.dispense();
        assertEquals(9, snack.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        snack.setQuantity(5);
        assertEquals(5, snack.getQuantity());
    }

    @Test
    public void testSetPrice() {
        snack.setPrice(2.0);
        assertEquals(2.0, snack.getPrice());
    }

    @Test
    public void testToString() {
        String expected = "Snack{name='Chips', price=1.5, quantity=10}";
        assertEquals(expected, snack.toString());
    }
}
