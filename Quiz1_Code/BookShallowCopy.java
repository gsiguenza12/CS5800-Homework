package com.company;

import java.util.List;

public class BookShallowCopy extends Book{

    public BookShallowCopy(String title, String author, List<String> chapters) {
        super(title, author, chapters);
    }
    @Override public BookShallowCopy clone() throws CloneNotSupportedException {
        return (BookShallowCopy) super.clone();
    }
}
