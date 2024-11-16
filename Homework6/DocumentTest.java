package com.company;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.*;

public class DocumentTest {

    private Document document;
    private Character character1;
    private Character character2;
    private CharacterProperties properties1;
    private CharacterProperties properties2;

    @BeforeEach
    public void setUp() {
        document = new Document();
        properties1 = new CharacterProperties("Arial", "Red", 12);
        properties2 = new CharacterProperties("Calibri", "Blue", 14);
        character1 = new Character('A', properties1);
        character2 = new Character('B', properties2);
    }

    @Test
    public void testAddCharacter() {
        document.addCharacter(character1);
        document.addCharacter(character2);
        assertEquals(2, document.getCharacters().size());
        assertEquals(character1, document.getCharacters().get(0));
        assertEquals(character2, document.getCharacters().get(1));
    }

    @Test
    public void testGetCharacters() {
        document.addCharacter(character1);
        List<Character> characters = document.getCharacters();
        assertEquals(1, characters.size());
        assertEquals(character1, characters.get(0));
    }

    @Test
    public void testSaveToFile() {
        document.addCharacter(character1);
        document.addCharacter(character2);
        document.saveToFile("test_document.dat");

        File file = new File("test_document.dat");
        assertTrue(file.exists());
    }

    @Test
    public void testLoadFromFile() {
        document.addCharacter(character1);
        document.addCharacter(character2);
        document.saveToFile("test_document.dat");

        Document loadedDocument = new Document();
        loadedDocument.loadFromFile("test_document.dat");

        List<Character> loadedCharacters = loadedDocument.getCharacters();
        assertEquals(2, loadedCharacters.size());
        assertEquals(character1.getCharacter(), loadedCharacters.get(0).getCharacter());
        assertEquals(character2.getCharacter(), loadedCharacters.get(1).getCharacter());
    }

    @Test
    public void testToString() {
        document.addCharacter(character1);
        document.addCharacter(character2);

        String expected = "AB";
        assertEquals(expected, document.toString());
    }

    @Test
    public void testPrintDetails() {
        document.addCharacter(character1);
        document.addCharacter(character2);

        document.printDetails();  // This will print details to the console. Verify manually if necessary.
    }
}
