package com.telusko.QuizApp.controller;

import com.telusko.QuizApp.model.Question;
import com.telusko.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();


    }


    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("difficultylevel/{difficultylevel}")
    public List<Question> getQuestionsBydifficultylevel(@PathVariable String difficultylevel) {
        return questionService.getQustionsBydfficultylevel(difficultylevel);
    }

    //adding a question
    @PostMapping("add")
    public ResponseEntity<String> addquestion(@RequestBody Question question) {
       return  questionService.addQuestion(question);
    }
    //deleting a question
    @DeleteMapping("delete")
    public String deleteQuestion(@RequestBody Question question ) {
        return questionService.deleteQuestion(question);
    }

    //updating a question
    @PutMapping("update")
    public String updateQuestion(@RequestBody Question question) {
        return questionService.updateQuestion(question);
    }

}
