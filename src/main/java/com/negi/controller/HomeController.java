package com.negi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/api/health")
    public String healthCheck() {
        return "Backend is running well";
    }

    @GetMapping("/")
    public String homeController() {
        return "Welcome to RecipeHub Backend!";
    }
}
