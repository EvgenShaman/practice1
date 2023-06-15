package com.example.demo;

import com.example.demo.service.BookService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    private EntityManager session;

    @Autowired
    private BookService bookService;

    @GetMapping("catalogue")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        Iterable<Book> books = bookService.getFiltered();
        model.addAttribute("books", books);
        Iterable<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "Catalogue";
    }
}