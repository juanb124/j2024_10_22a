package com.example.lab5.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    private final List<QuizQuestion> questions;
    
    public QuizService() {
        questions = new ArrayList<>();
        initializeQuestions();
    }
    
    private void initializeQuestions() {
        questions.add(new QuizQuestion(
            "What is the capital of Italy?",
            List.of("London", "Vatican City", "Paris", "Rome"),
            2
        ));
        questions.add(new QuizQuestion(
            "Which planet is closest to the Sun?",
            List.of("Venus", "Mercury", "Mars", "Earth"),
            1
        ));
        // Add more questions as needed
    }
    
    public List<QuizQuestion> getAllQuestions() {
        return new ArrayList<>(questions);
    }
    
    public QuizQuestion getQuestion(int index) {
        if (index >= 0 && index < questions.size()) {
            return questions.get(index);
        }
        return null;
    }
    
    public static class QuizQuestion {
        private final String question;
        private final List<String> options;
        private final int correctOptionIndex;
        
        public QuizQuestion(String question, List<String> options, int correctOptionIndex) {
            this.question = question;
            this.options = options;
            this.correctOptionIndex = correctOptionIndex;
        }
        
        // Getters
        public String getQuestion() { return question; }
        public List<String> getOptions() { return options; }
        public int getCorrectOptionIndex() { return correctOptionIndex; }
    }
}
