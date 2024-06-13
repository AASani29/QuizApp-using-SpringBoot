package com.telusko.QuizApp.controller;

import com.telusko.QuizApp.Question;
import com.telusko.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();


    }


    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("difficultylevel/{difficultylevel}")
    public List<Question> getQuestionsBydifficultylevel(@PathVariable String difficultylevel) {
        return questionService.getQustionsBydfficultylevel(difficultylevel);
    }

    //adding a question
    @PostMapping("add")
    public String addquestion(@RequestBody Question question) {
       return  questionService.addQuestion(question);
    }
    //deleting a question
    @DeleteMapping("delete")
    public String deleteQuestion(@RequestBody Question question ) {
        return questionService.deleteQuestion(question);
    }

}
