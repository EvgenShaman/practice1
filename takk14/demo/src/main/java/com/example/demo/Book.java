package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Book {
    static List<Book> books = new ArrayList<>();
    String name;
    String creationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Book(String name, String creationDate) {
        this.name = name;
        this.creationDate = creationDate;
        books.add(this);
        System.out.println("ssss");
    }
}
