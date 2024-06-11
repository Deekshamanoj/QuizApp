package com.tyss.QuizApp.dao;

import java.util.List;

import com.tyss.QuizApp.entity.Quiz;

public interface QuizDao {

	Quiz saveQuiz(Quiz quiz);

	List<Quiz> findAll();

	Quiz findById(int id);
	

}
