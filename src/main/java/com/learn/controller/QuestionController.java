package com.learn.controller;

import com.learn.model.Question;
import com.learn.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping("/all")
    public ResponseEntity<?> saveAllQuestions(@RequestBody List<Question> questions) {
        return questionService.saveAllQuestions(questions);
    }
}
