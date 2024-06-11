package com.tyss.QuizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.QuizApp.entity.Quiz;
import com.tyss.QuizApp.enums.DifficultyLevel;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

	
}
