package com.example.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CatalogueController {
    @Autowired
    private FoodRepository foodRepository;
    @GetMapping("/catalogue")
    public String greeting(Model model) {
        Iterable<Food> food = foodRepository.findAll();
        model.addAttribute("food", food);
        return "Catalogue";
    }
}