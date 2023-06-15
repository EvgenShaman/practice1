package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class BeanConfig {
    @Bean
    @Scope("prototype")
    public Programmer junior() {
        return new Junior();
    }
    @Bean
    @Scope("prototype")
    public Programmer middle() {
        return new Middle();
    }
    @Bean
    @Scope("prototype")
    public Programmer senior() {
        return new Seniour();
    }

}
