package com.example.demo;

import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddController1 {
    @Autowired
    EmailService emailService;
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private BookRepository bookRepository;
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private AuthorRepository authorRepository;
    @GetMapping("/add1")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "Add1";
    }
    @PostMapping(path="/add1") // Map ONLY POST Requests
    public @ResponseBody String addNewFood (@RequestParam String name
            , @RequestParam String creationDate , @RequestParam Long authorId) {

        Book n = new Book(name, creationDate, bookRepository.findAll().size());
        n.setAuthor(authorRepository.getReferenceById(authorId));
        bookRepository.save(n);
        emailService.send();
        return "redirect:/catalogue";
    }
}
