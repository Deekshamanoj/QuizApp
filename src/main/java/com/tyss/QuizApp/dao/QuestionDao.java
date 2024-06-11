package com.tyss.QuizApp.dao;

import java.util.List;

import com.tyss.QuizApp.entity.Question;
import com.tyss.QuizApp.enums.DifficultyLevel;

public interface QuestionDao {
	
	Question saveQuestion(Question question);
	
	List<Question> getAllQuestion();

	List<Question> getQuestionsByCategory(String category);

	List<Question> getQuestionsByDifficultyLevel(DifficultyLevel difficultyLevel);

	List<Question> getRandomQuestionByCategoryAndDifficultyLevel(String category, DifficultyLevel difficultyLevel, int numQue);

}
