package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    @Test
    public void testConstructorAndGetters() {
        CharacterProperties properties = new CharacterProperties("Arial", "Red", 12);
        Character character = new Character('A', properties);

        assertEquals('A', character.getCharacter());
        assertEquals(properties, character.getProperties());
    }

    @Test
    public void testSetCharacter() {
        CharacterProperties properties = new CharacterProperties("Arial", "Red", 12);
        Character character = new Character('A', properties);

        character.setCharacter('B');
        assertEquals('B', character.getCharacter());
    }

    @Test
    public void testSetProperties() {
        CharacterProperties properties1 = new CharacterProperties("Arial", "Red", 12);
        CharacterProperties properties2 = new CharacterProperties("Calibri", "Blue", 14);
        Character character = new Character('A', properties1);

        character.setProperties(properties2);
        assertEquals(properties2, character.getProperties());
    }

    @Test
    public void testToString() {
        CharacterProperties properties = new CharacterProperties("Arial", "Red", 12);
        Character character = new Character('A', properties);

        String expected = "Character{character=A, properties=CharacterProperties{font='Arial', color='Red', size=12}}";
        assertEquals(expected, character.toString());
    }
}

