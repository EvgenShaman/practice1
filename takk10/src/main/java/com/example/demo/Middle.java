package com.example.demo;

import org.springframework.context.annotation.Scope;

public class Middle implements Programmer{
    @Override
    @Scope("prototype")
    public void doCoding() {
        System.out.println("i++;");
    }
}
