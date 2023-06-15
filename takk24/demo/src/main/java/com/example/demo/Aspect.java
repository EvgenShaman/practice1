package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    public float time;
    @Before("within(com.example.demo.service.*)")
    public void startTimer(JoinPoint joinPoint) {
        time = System.nanoTime();
    }
    @After("within(com.example.demo.service.*)")
    public void logTime(JoinPoint joinPoint) {
        float time2 = System.nanoTime();
        log.info("Complition time " + Float.toString(time2-time/1000000000) + "s");
    }
}