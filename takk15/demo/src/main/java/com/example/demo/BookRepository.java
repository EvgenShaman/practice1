package com.example.demo;

import com.example.demo.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called foodRepository
// CRUD refers Create, Read, Update, Delete

public interface BookRepository extends JpaRepository<Book, Long> {

}