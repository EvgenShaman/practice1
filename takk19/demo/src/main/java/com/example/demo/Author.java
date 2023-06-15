package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="authors")
@Table(name = "authors")

@Getter
@Setter
public class Author {
    @Id
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    static List<Author> authors  = new ArrayList<>();
    @Column(name = "first_name")

    String firstName;
    @Column(name = "last_name")

    String lastName;
    @Column(name = "middle_name")

    String middleName;
    @Column(name = "birth_date")

    String birthDate;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author(){}
    public Author(String firstName, String lastName, String middleName, String birthDate, int id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        authors.add(this);
    }
}
