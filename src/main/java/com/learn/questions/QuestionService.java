package com.learn.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<Question> saveQuestion(Question question) {
        try {
            question.setDate(LocalDateTime.now());
            Question response = questionRepository.save(question);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Question>> saveAllQuestion(List<Question> questionList) {
        try {
            for (Question question : questionList) {
                question.setDate(LocalDateTime.now());
            }
            List<Question> response = questionRepository.saveAll(questionList);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Optional<Question>> getQuestionById(Long id) {
        try {
            Optional<Question> response = questionRepository.findById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Question>> getAllQuestion() {
        try {
            List<Question> response = questionRepository.findAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Question> updateQuestion(Question newQuestion, Long id) {
        newQuestion.setDate(LocalDateTime.now());
        try {
            Question oldQuestion = questionRepository.findById(id).orElse(null);
            if (oldQuestion != null) {
                oldQuestion.setName(oldQuestion.getName().equals(newQuestion.getName()) ? oldQuestion.getName() : newQuestion.getName());
                oldQuestion.setOption1(oldQuestion.getOption1().equals(newQuestion.getOption1()) ? oldQuestion.getOption1() : newQuestion.getOption1());
                oldQuestion.setOption2(oldQuestion.getOption2().equals(newQuestion.getOption2()) ? oldQuestion.getOption2() : newQuestion.getOption2());
                oldQuestion.setOption3(oldQuestion.getOption3().equals(newQuestion.getOption3()) ? oldQuestion.getOption3() : newQuestion.getOption3());
                oldQuestion.setOption4(oldQuestion.getOption4().equals(newQuestion.getOption4()) ? oldQuestion.getOption4() : newQuestion.getOption4());
                oldQuestion.setResult(oldQuestion.getResult().equals(newQuestion.getResult()) ? oldQuestion.getResult() : newQuestion.getResult());
                oldQuestion.setCategory(oldQuestion.getCategory().equals(newQuestion.getCategory()) ? oldQuestion.getCategory() : newQuestion.getCategory());
                Question response = questionRepository.save(oldQuestion);
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteQuestionById(Long id) {
        try {
            questionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<HttpStatus> deleteAllQuestions() {
        try {
            questionRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public List<Question> findByCategory(String category) {
        return questionRepository.findByCategory(category);
    }
}
