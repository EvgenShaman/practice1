package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddController2 {

    @GetMapping("/add2")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "Add2";
    }
    @PostMapping(path="/add2") // Map ONLY POST Requests
    public @ResponseBody String addNewFood (@RequestParam String firstName, @RequestParam String lastName
            , @RequestParam String middleName, @RequestParam String birthDate) {
        Author n = new Author(firstName, lastName, middleName, birthDate);
        return "redirect:/catalogue";
    }
}