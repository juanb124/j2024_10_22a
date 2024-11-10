package com.example.lab5.service;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator {
    public boolean isValidEmail(String email) {
        // Basic email validation using regex
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (email == null) return false;
        return email.matches(emailRegex);
    }
}