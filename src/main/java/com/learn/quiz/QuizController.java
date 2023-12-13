package com.learn.quiz;

import com.learn.model.QuestionWrapper;
import com.learn.model.Quiz;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizController {
    public ResponseEntity<HttpStatus> createQuiz(String title, String category);
    public ResponseEntity<List<QuestionWrapper>> getQuizById(Long id);
    public ResponseEntity<HttpStatus> updateQuizById(Quiz newQuiz,Long id);
    public ResponseEntity<HttpStatus> deleteQuizById(Long id);
    public ResponseEntity<HttpStatus> deleteAllQuiz();
}
