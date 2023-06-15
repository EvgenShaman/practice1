package com.example.demo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="book")
@Table(name = "book")
public class Book {
    @Id
    public int id;
    static List<Book> books = new ArrayList<>();
    @Column(name = "name")
    String name;
    @Column(name = "creation_date")
    String creationDate;

    @ManyToOne
    public Author author;

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

    public Book() {}

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
