package com.example.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.put("message", "User Exists");
            return "registration";
        }
        user.setActive(true);
        user.setRole("USER");
        user.setPoints(500);
        BCryptPasswordEncoder code = new BCryptPasswordEncoder();
        user.setPassword(code.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
}
