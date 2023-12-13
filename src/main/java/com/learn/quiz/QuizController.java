package com.learn.quiz;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizController {
    public ResponseEntity<HttpStatus> createQuiz(String title, String category, int range);
    public ResponseEntity<Quiz> getQuizById(Long id);
    public ResponseEntity<List<Quiz>> getAllQuiz();
    public ResponseEntity<HttpStatus> updateQuizById(Quiz newQuiz,Long id);
    public ResponseEntity<HttpStatus> deleteQuizById(Long id);
    public ResponseEntity<HttpStatus> deleteAllQuiz();
}
