package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterPropertiesTest {

    @Test
    public void testConstructorAndGetters() {
        CharacterProperties properties = new CharacterProperties("Arial", "Red", 12);

        assertEquals("Arial", properties.getFont());
        assertEquals("Red", properties.getColor());
        assertEquals(12, properties.getSize());
    }

    @Test
    public void testSetFont() {
        CharacterProperties properties = new CharacterProperties("Arial", "Red", 12);
        properties.setFont("Calibri");

        assertEquals("Calibri", properties.getFont());
    }

    @Test
    public void testSetColor() {
        CharacterProperties properties = new CharacterProperties("Arial", "Red", 12);
        properties.setColor("Blue");

        assertEquals("Blue", properties.getColor());
    }

    @Test
    public void testSetSize() {
        CharacterProperties properties = new CharacterProperties("Arial", "Red", 12);
        properties.setSize(14);

        assertEquals(14, properties.getSize());
    }

    @Test
    public void testToString() {
        CharacterProperties properties = new CharacterProperties("Arial", "Red", 12);

        String expected = "CharacterProperties{font='Arial', color='Red', size=12}";
        assertEquals(expected, properties.toString());
    }
}
