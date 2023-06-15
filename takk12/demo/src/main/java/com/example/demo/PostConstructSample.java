package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class PostConstructSample{
    @PostConstruct
    public void init() throws NoSuchAlgorithmException {
        System.out.println("Bean is ready");
        MessageDigest md = MessageDigest.getInstance("MD5");
        try (InputStream is = Files.newInputStream(Paths.get("file.txt"));
             DigestInputStream dis = new DigestInputStream(is, md))
        {
            /* Read decorated stream (dis) to EOF as normal... */
        } catch (IOException e) {

        }
        byte[] digest = md.digest();
        FileOutputStream out = null;
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("file2.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        writer.println(digest);
        writer.close();

    }
}
