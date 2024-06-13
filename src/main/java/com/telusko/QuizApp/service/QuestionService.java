package com.telusko.QuizApp.service;

import com.telusko.QuizApp.Dao.QuestionDao;
import com.telusko.QuizApp.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public List<Question> getQustionsBydfficultylevel(String dfficultylevel)  {
        return questionDao.findByDifficultyLevel(dfficultylevel);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";
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
