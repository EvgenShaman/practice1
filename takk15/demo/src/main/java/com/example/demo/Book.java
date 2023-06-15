package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity(name="book")
public class Book {
    @Id
    public int id;
    static List<Book> books = new ArrayList<>();
    String name;
    String creationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Book(String name, String creationDate, int id) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        books.add(this);
    }
}
