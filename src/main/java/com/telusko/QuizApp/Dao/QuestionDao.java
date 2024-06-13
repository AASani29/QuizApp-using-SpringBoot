package com.telusko.QuizApp.Dao;

import com.telusko.QuizApp.Question;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);
    List<Question> findByDifficultyLevel(String difficultyLevel);





}
