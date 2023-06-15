package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    @Async
    public void send(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("botbootbot@yandex.ru");
        mailMessage.setTo("Spiralily@yandex.ru");
        mailMessage.setSubject("Your DB");
        mailMessage.setText("Your DB has been changed");

        this.mailSender.send(mailMessage);
    }
}
