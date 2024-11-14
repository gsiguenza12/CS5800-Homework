package com.company;

import java.util.List;

public class Book implements Cloneable{
    private String title;
    private String author;
    private List<String> chapters;

    public Book(String title, String author, List<String> chapters) {
        this.title = title;
        this.author = author;
        this.chapters = chapters;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getChapters() {
        return chapters;
    }

    public void setChapters(List<String> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", chapters=" + chapters +
                '}';
    }

    @Override
    public Book clone() throws CloneNotSupportedException {
        Book clone;

        try{
            clone = (Book) super.clone();
        } catch(CloneNotSupportedException ex){
            throw new AssertionError();
        }
        return clone;
    }
}
