package com.learn.quiz;

import com.learn.model.QuestionWrapper;
import com.learn.model.Quiz;
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
    public ResponseEntity<HttpStatus> createQuiz(@RequestParam String title, @RequestParam String category) {
        return quizService.createQuiz(title, category);
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id);
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
