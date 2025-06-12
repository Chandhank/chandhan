package com.example.murugar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class MurugarApp {
    public static void main(String[] args) {
        SpringApplication.run(MurugarApp.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "<html><body style='text-align:center; background:#222; color:#FFD700; font-family:sans-serif;'>" +
               "<h1>நல்லதே நடக்கும் Murugan</h1>" +
               "<img src='/murugar.jpg' width='500'>" +
               "</body></html>";
    }
}

