package com.telusko.QuizApp.Dao;

import com.telusko.QuizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);
    List<Question> findByDifficultyLevel(String difficultyLevel);

    @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() Limit :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
    //void deleteById(Integer id);





}
