package com.company;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // FLYWEIGHT DEMO
        Document doc1 = new Document();
        Document doc2 = new Document();
        Document doc3 = new Document();
        Document doc4 = new Document();
        String text = "HelloWorldCS5800";

        CharacterProperties properties1 = CharacterPropertiesFactory.getCharacterProperties("Arial", "Red", 12);
        CharacterProperties properties2 = CharacterPropertiesFactory.getCharacterProperties("Calibri", "Blue", 14);
        CharacterProperties properties3 = CharacterPropertiesFactory.getCharacterProperties("Verdana", "Black", 16);
        CharacterProperties properties4 = CharacterPropertiesFactory.getCharacterProperties("Times New Roman", "Cyan",18);

        for (char c : text.toCharArray()) {
            doc1.addCharacter(new Character(c, properties1));
        }

        // Document 2
        for (char c : text.toCharArray()) {
            doc2.addCharacter(new Character(c, properties2));
        }
        // Document 3
        for (char c : text.toCharArray()) { doc3.addCharacter(new Character(c, properties3)); }

        // Document 4
        for (char c : text.toCharArray()) { doc4.addCharacter(new Character(c, properties4)); }

        System.out.println("Document content: " + doc1.toString());
        doc1.saveToFile("document1.dat");
        Document loadedDoc1 = new Document();
        loadedDoc1.loadFromFile("document.dat");
        System.out.println("Loaded document 1 content: " + loadedDoc1.toString());
        System.out.println("Loaded document 1 content's properties: ");
        loadedDoc1.printDetails();

        System.out.println("Document 2 content: " + doc2.toString());
        doc2.saveToFile("document2.dat");
        Document loadedDoc2 = new Document();
        loadedDoc2.loadFromFile("document2.dat");
        System.out.println("Loaded document 2 content: " + loadedDoc2.toString());
        System.out.println("Loaded document 2 content's properties: ");
        loadedDoc2.printDetails();

        System.out.println("Document 3 content: " + doc3.toString());
        doc3.saveToFile("document3.dat");
        Document loadedDoc3 = new Document();
        loadedDoc3.loadFromFile("document3.dat");
        System.out.println("Loaded document 3 content: " + loadedDoc3.toString());
        System.out.println("Loaded document 3 content's properties: ");
        loadedDoc3.printDetails();

        System.out.println("Document 4 content: " + doc4.toString());
        doc4.saveToFile("document4.dat");
        Document loadedDoc4 = new Document();
        loadedDoc4.loadFromFile("document4.dat");
        System.out.println("Loaded document 4 content: " + loadedDoc4.toString());
        System.out.println("Loaded document 4 content's properties: ");
        loadedDoc4.printDetails();

        // PROXY DEMO
        SongService realService = new RealSongService();
        SongService proxyService = new SongServiceProxy(realService); // Adding a 1-second delay to simulate network latency in the real service
        System.out.println("\nSearching for song by ID (4) with simulated network latency...");
        System.out.println(proxyService.searchByID(4)); // Should take 1 second
        System.out.println("Searching for song by ID (4) using Proxy SongService...");
        System.out.println(proxyService.searchByID(4)); // Should be instant due to caching

        System.out.println("\nSearching for song by title (Bohemian Rhapsody) with simulated network latency...");
        System.out.println(proxyService.seachByTitle("Bohemian Rhapsody")); // Should take 1 second
        System.out.println("Searching for song by title (Bohemian Rhapsody) using Proxy SongService...");
        System.out.println(proxyService.seachByTitle("Bohemian Rhapsody")); // Should be instant due to caching

        System.out.println("\nSearching for song by album (Led Zeppelin IV) with simulated network latency...");
        System.out.println(proxyService.searchByAlbum("Led Zeppelin IV")); // Should take 1 second
        System.out.println("Searching for song by album (Led Zeppelin IV) using Proxy SongService...");
        System.out.println(proxyService.searchByAlbum("Led Zeppelin IV")); // Should be instant due to caching

        System.out.println("\nSearching for song by album (Thriller) with simulated network latency...");
        System.out.println(proxyService.searchByAlbum("Thriller")); // Should take 1 second
        System.out.println("Searching for song by album (Thriller) using Proxy SongService...");
        System.out.println(proxyService.searchByAlbum("Thriller")); // Should be instant due to caching
    }
}