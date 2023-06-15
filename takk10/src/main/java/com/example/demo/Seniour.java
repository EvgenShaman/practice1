package com.example.demo;

import org.springframework.context.annotation.Scope;

public class Seniour implements Programmer{
    @Override
    @Scope("prototype")
    public void doCoding() {
        System.out.println("++i;");
    }
}
