package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddController1 {

    @GetMapping("/add1")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "Add1";
    }
    @PostMapping(path="/add1") // Map ONLY POST Requests
    public @ResponseBody String addNewFood (@RequestParam String name
            , @RequestParam String creationDate) {

        Book n = new Book(name, creationDate);
        return "redirect:/catalogue";
    }
}
