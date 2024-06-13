package com.telusko.QuizApp.service;

import com.telusko.QuizApp.Dao.QuestionDao;
import com.telusko.QuizApp.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
}
