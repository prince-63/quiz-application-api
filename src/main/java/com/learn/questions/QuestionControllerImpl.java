package com.learn.questions;

import com.learn.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionControllerImpl implements QuestionController {

    @Autowired
    private QuestionService questionService;

    @Override
    @PostMapping("/save")
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    @Override
    @PostMapping("/save/all")
    public ResponseEntity<List<Question>> saveAllQuestion(@RequestBody List<Question> questionList) {
        return questionService.saveAllQuestion(questionList);
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @Override
    @PutMapping("save/{id}")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question, @PathVariable Long id) {
        return questionService.updateQuestion(question, id);
    }

    @Override
    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> deleteQuestionById(Long id) {
        return questionService.deleteQuestionById(id);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllQuestions() {
        return questionService.deleteAllQuestions();
    }
}
