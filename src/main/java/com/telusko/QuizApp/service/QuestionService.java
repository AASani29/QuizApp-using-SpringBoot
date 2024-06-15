package com.telusko.QuizApp.service;

import com.telusko.QuizApp.Dao.QuestionDao;
import com.telusko.QuizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<Question>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {

        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<Question>(), HttpStatus.BAD_REQUEST);

    }

    public List<Question> getQustionsBydfficultylevel(String dfficultylevel)  {
        return questionDao.findByDifficultyLevel(dfficultylevel);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED) ;
    }

    public String deleteQuestion(Question question) {
        questionDao.delete(question);
        return "Question deleted successfully";
    }

    public String updateQuestion(Question updatedQuestion) {
        Optional<Question> existingQuestion = questionDao.findById(updatedQuestion.getId());
        if (existingQuestion.isPresent()) {
            Question question = existingQuestion.get();
            question.setCategory(updatedQuestion.getCategory())             ;
            question.setDifficultyLevel(updatedQuestion.getDifficultyLevel());

            // update other fields as needed
            questionDao.save(question);
            return "Question updated successfully";
        } else {
            return "Question not found";
        }
    }

}
