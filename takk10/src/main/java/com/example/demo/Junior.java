package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class Junior implements Programmer
{
    @Override
    public void doCoding() {
        System.out.println("i += 1;");
    }
}
