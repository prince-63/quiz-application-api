package com.learn.quiz;

import com.learn.model.Question;
import com.learn.model.QuestionWrapper;
import com.learn.model.Quiz;
import com.learn.questions.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<HttpStatus> createQuiz(String title, String category) {
        try {
            List<Question> questionList = questionRepository.findByCategory(category);
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setCategory(category);
            quiz.setDate(LocalDateTime.now());
            quiz.getListOfQuestions().addAll(questionList);
            quizRepository.save(quiz);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizById(Long id) {
        try {
            List<Question> questionList = quizRepository.findById(id).get().getListOfQuestions();
            log.info(questionList.toString());
            List<QuestionWrapper> questionWrappers = new ArrayList<QuestionWrapper>();
            for (Question question : questionList) {
                QuestionWrapper questionWrapper = new QuestionWrapper();
                questionWrapper.setId(question.getId());
                questionWrapper.setQuestionName(question.getName());
                questionWrapper.setOption1(question.getOption1());
                questionWrapper.setOption2(question.getOption2());
                questionWrapper.setOption3(question.getOption3());
                questionWrapper.setOption4(question.getOption4());
                questionWrappers.add(questionWrapper);
            }
            return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteQuizById(Long id) {
        try {
            quizRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
