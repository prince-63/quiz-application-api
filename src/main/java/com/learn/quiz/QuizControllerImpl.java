package com.learn.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizControllerImpl implements QuizController{

    @Autowired
    private QuizService quizService;

    @Override
    @PostMapping("/save")
    public ResponseEntity<HttpStatus> createQuiz(@RequestParam String title, @RequestParam String category, @RequestParam int range) {
        return quizService.createQuiz(title, category, range);
    }

    @Override
    public ResponseEntity<Quiz> getQuizById(Long id) {
        return null;
    }

    @Override
    @GetMapping()
    public ResponseEntity<List<Quiz>> getAllQuiz() {
        return quizService.getAllQuiz();
    }

    @Override
    public ResponseEntity<HttpStatus> updateQuizById(Quiz newQuiz, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteQuizById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAllQuiz() {
        return null;
    }
}
