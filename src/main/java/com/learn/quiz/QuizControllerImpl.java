package com.learn.quiz;

import com.learn.model.QuestionWrapper;
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
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteQuizById(@PathVariable Long id) {
        return quizService.deleteQuizById(id);
    }

}
