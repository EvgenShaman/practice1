package com.example.demo;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class PreDestroySample {
    @PreDestroy
    public void destroy(){
        File file = new File("file.txt");
        file.delete();
    }
}
