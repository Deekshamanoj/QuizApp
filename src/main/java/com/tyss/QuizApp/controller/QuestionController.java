package com.tyss.QuizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.QuizApp.dto.ResponseStructure;
import com.tyss.QuizApp.entity.Question;
import com.tyss.QuizApp.enums.DifficultyLevel;
import com.tyss.QuizApp.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService quizAppService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Question>> saveQuestion(@RequestBody Question question)
	{
		return quizAppService.saveQuestion(question);
	}
	
	@GetMapping("/allQuestions")
	public ResponseEntity<ResponseStructure<List<Question>>> getAllQuestions()
	{
		return quizAppService.getAllquestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<ResponseStructure<List<Question>>> getQuestionsByCategory(@PathVariable String category)
	{
		return quizAppService.getQuestionsByCategory(category);
	}
	
	@GetMapping("/difficultyLevel/{difficultyLevel}")
	public ResponseEntity<ResponseStructure<List<Question>>> getQuestionsByDifficultyLevel(@PathVariable DifficultyLevel difficultyLevel)
	{
		return quizAppService.getQuestionsByDifficultyLevel(difficultyLevel);
	}
	
	

}
