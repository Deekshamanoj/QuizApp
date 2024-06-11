package com.tyss.QuizApp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.QuizApp.dto.ResponseStructure;
import com.tyss.QuizApp.entity.Question;
import com.tyss.QuizApp.enums.DifficultyLevel;

public interface QuestionService {
	
	ResponseEntity<ResponseStructure<Question>> saveQuestion(Question question);

	ResponseEntity<ResponseStructure<List<Question>>> getAllquestions();

	ResponseEntity<ResponseStructure<List<Question>>> getQuestionsByCategory(String category);

	ResponseEntity<ResponseStructure<List<Question>>> getQuestionsByDifficultyLevel(DifficultyLevel difficultyLevel);

}
