package com.tyss.QuizApp.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tyss.QuizApp.dto.QuestionDto;
import com.tyss.QuizApp.dto.Response;
import com.tyss.QuizApp.dto.ResponseStructure;
import com.tyss.QuizApp.entity.Quiz;
import com.tyss.QuizApp.enums.DifficultyLevel;

public interface QuizService {

	ResponseEntity<ResponseStructure<Quiz>> createQuiz(String category, DifficultyLevel difficultyLevel, int numQue,
			String title);

	ResponseEntity<ResponseStructure<List<Quiz>>> getAllQuiz();

	ResponseEntity<ResponseStructure<Quiz>> getQuizById(int id);

	ResponseEntity<ResponseStructure<List<QuestionDto>>> getQuizQuestionsById(int id);

	ResponseEntity<ResponseStructure<Integer>> calculateResult(int id, List<Response> response);

}
