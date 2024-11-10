package com.example.lab5.controller;

import com.example.lab5.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {
    
    @Autowired
    private PasswordValidator passwordValidator;
    
    @Autowired
    private EmailValidator emailValidator;
    
    @Autowired
    private QuizService quizService;
    
    @PostMapping("/password/check")
    public ResponseEntity<PasswordValidator.PasswordStrength> checkPassword(@RequestBody String password) {
        PasswordValidator.PasswordStrength strength = passwordValidator.checkPassword(password);
        return ResponseEntity.ok(strength);
    }
    
    @GetMapping("/email/validate")
    public ResponseEntity<Boolean> validateEmail(@RequestParam String email) {
        boolean isValid = emailValidator.isValidEmail(email);
        return ResponseEntity.ok(isValid);
    }
    
    @GetMapping("/quiz/questions")
    public ResponseEntity<QuizService.QuizQuestion> getQuestion(@RequestParam(defaultValue = "0") int index) {
        QuizService.QuizQuestion question = quizService.getQuestion(index);
        if (question != null) {
            return ResponseEntity.ok(question);
        }
        return ResponseEntity.notFound().build();
    }
}