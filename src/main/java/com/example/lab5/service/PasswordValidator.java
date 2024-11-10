package com.example.lab5.service;

import org.springframework.stereotype.Service;

@Service
public class PasswordValidator {
    public PasswordStrength checkPassword(String password) {
        int score = 0;
        
        // Length check
        if (password.length() >= 8) score++;
        if (password.length() >= 12) score++;
        
        // Character variety checks
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) score++;
        
        // Convert score to strength enum
        if (score <= 2) return PasswordStrength.WEAK;
        if (score <= 4) return PasswordStrength.MEDIUM;
        return PasswordStrength.STRONG;
    }
    
    public enum PasswordStrength {
        WEAK, MEDIUM, STRONG
    }
}