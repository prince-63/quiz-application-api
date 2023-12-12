package com.learn.questions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface QuestionController {
    public ResponseEntity<Question> saveQuestion(Question question);

    public ResponseEntity<List<Question>> saveAllQuestion(List<Question> questionList);

    public ResponseEntity<Optional<Question>> getQuestionById(Long id);

    public ResponseEntity<List<Question>> getAllQuestion();

    public ResponseEntity<Question> updateQuestion(Question question, Long id);

    public ResponseEntity<HttpStatus> deleteQuestionById(Long id);

    public ResponseEntity<HttpStatus> deleteAllQuestions();
}
