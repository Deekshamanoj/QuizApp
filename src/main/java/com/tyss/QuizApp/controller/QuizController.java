package com.tyss.QuizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tyss.QuizApp.dto.QuestionDto;
import com.tyss.QuizApp.dto.Response;
import com.tyss.QuizApp.dto.ResponseStructure;
import com.tyss.QuizApp.entity.Quiz;
import com.tyss.QuizApp.enums.DifficultyLevel;
import com.tyss.QuizApp.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService ;
	
	@GetMapping("/create")
	public ResponseEntity<ResponseStructure<Quiz>> createQuiz(@RequestParam String category, @RequestParam DifficultyLevel difficultyLevel, @RequestParam int numQue, @RequestParam String title)
	{
		return quizService.createQuiz(category,difficultyLevel,numQue,title);
	}
	
	@GetMapping("/getAllQuiz")
	public ResponseEntity<ResponseStructure<List<Quiz>>> getAllQuiz()
	{
		return quizService.getAllQuiz();
	}
	
	@GetMapping("/QuizId/{id}")
	public ResponseEntity<ResponseStructure<Quiz>> getQuizById(@PathVariable int id)
	{
		return quizService.getQuizById(id);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseStructure<List<QuestionDto>>> getQuizQuestionById(@PathVariable int id)
	{
		return quizService.getQuizQuestionsById(id);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<ResponseStructure<Integer>> submitQuiz(@PathVariable int id , @RequestBody List<Response> response)
	{
		return quizService.calculateResult(id,response);
	}

}
