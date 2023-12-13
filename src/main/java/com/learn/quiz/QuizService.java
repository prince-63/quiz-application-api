package com.learn.quiz;

import com.learn.questions.Question;
import com.learn.questions.QuestionRepository;
import com.learn.questions.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionService questionService;

    public ResponseEntity<HttpStatus> createQuiz(String title, String category, int range) {
        try {
            List<Question> questionList = questionService.findByCategory(category);
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setDate(LocalDateTime.now());
            quiz.getListOfQuestions().addAll(questionList);
            quizRepository.save(quiz);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    public ResponseEntity<List<Quiz>> getAllQuiz() {
        try {
            List<Quiz> quizList = quizRepository.findAll();
            return new ResponseEntity<>(quizList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
