package com.example.lab5;

import com.example.lab5.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class Lab5ApplicationTests {

    @Autowired
    private PasswordValidator passwordValidator;
    
    @Autowired
    private EmailValidator emailValidator;
    
    @Autowired
    private QuizService quizService;

    @Test
    void testPasswordStrength() {
        assertEquals(PasswordValidator.PasswordStrength.WEAK, 
            passwordValidator.checkPassword("short"));
        assertEquals(PasswordValidator.PasswordStrength.MEDIUM, 
            passwordValidator.checkPassword("Password123"));
        assertEquals(PasswordValidator.PasswordStrength.STRONG, 
            passwordValidator.checkPassword("StrongP@ssw0rd"));
    }

    @Test
    void testEmailValidation() {
        assertTrue(emailValidator.isValidEmail("test@example.com"));
        assertTrue(emailValidator.isValidEmail("user.name@domain.co.uk"));
        assertFalse(emailValidator.isValidEmail("invalid.email"));
        assertFalse(emailValidator.isValidEmail("@domain.com"));
        assertFalse(emailValidator.isValidEmail(null));
    }

    @Test
    void testQuizQuestions() {
        assertNotNull(quizService.getQuestion(0));
        assertNotNull(quizService.getQuestion(1));
        assertNull(quizService.getQuestion(99)); // Invalid index
        
        assertTrue(quizService.getAllQuestions().size() > 0);
        assertNotNull(quizService.getAllQuestions().get(0).getQuestion());
        assertNotNull(quizService.getAllQuestions().get(0).getOptions());
    }
}