package com.company;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Shallow Copy Example with "Pride and Prejudice"
        List<String> prideChapters = new ArrayList<>();
        prideChapters.add("Chapter 1: It is a truth universally acknowledged...");
        prideChapters.add("Chapter 2: Mr. Bennet was among the earliest of those...");

        BookShallowCopy originalPrideBook = new BookShallowCopy("Pride and Prejudice", "Jane Austen", prideChapters);
        BookShallowCopy clonedPrideBook = originalPrideBook.clone();

        // Modify the chapters of the original shallow book
        originalPrideBook.getChapters().add("Chapter 3: Not all that Mrs. Bennet...");

        // Outputs of both shallow copy books
        System.out.println("Original Shallow Book: " + originalPrideBook);
        System.out.println("Cloned Shallow Book: " + clonedPrideBook);

        // Deep Copy Example with "1984"
        List<String> nineteenChapters = new ArrayList<>();
        nineteenChapters.add("Chapter 1: It was a bright cold day in April...");
        nineteenChapters.add("Chapter 2: As he put his hand to the door-knob...");

        BookDeepCopy originalNineteenBook = new BookDeepCopy("1984", "George Orwell", nineteenChapters);
        BookDeepCopy clonedNineteenBook = originalNineteenBook.clone();

        // Modify the chapters of the original deep book
        originalNineteenBook.getChapters().add("Chapter 3: The Ministry of Truth...");

        // Outputs of both deep copy books
        System.out.println("Original Deep Book: " + originalNineteenBook);
        System.out.println("Cloned Deep Book: " + clonedNineteenBook);
    }
}
