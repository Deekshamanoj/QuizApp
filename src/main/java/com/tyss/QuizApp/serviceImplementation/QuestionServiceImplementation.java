package com.tyss.QuizApp.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.QuizApp.dao.QuestionDao;
import com.tyss.QuizApp.dto.ResponseStructure;
import com.tyss.QuizApp.entity.Question;
import com.tyss.QuizApp.enums.DifficultyLevel;
import com.tyss.QuizApp.service.QuestionService;

@Service
public class QuestionServiceImplementation implements QuestionService {

	@Autowired
	private QuestionDao quizAppDao ;
	
	@Override
	public ResponseEntity<ResponseStructure<Question>> saveQuestion(Question question) {
		
		ResponseStructure<Question> responseStructure = new ResponseStructure<Question>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("CREATED");
		responseStructure.setData(quizAppDao.saveQuestion(question));
		
		return new ResponseEntity<ResponseStructure<Question>>(responseStructure, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Question>>> getAllquestions() {
		ResponseStructure<List<Question>> responseStructure = new ResponseStructure<List<Question>>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("OK");
		responseStructure.setData(quizAppDao.getAllQuestion());
		
		return new ResponseEntity<ResponseStructure<List<Question>>>(responseStructure, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Question>>> getQuestionsByCategory(String category) {
		ResponseStructure<List<Question>> responseStructure = new ResponseStructure<List<Question>>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("OK");
		responseStructure.setData(quizAppDao.getQuestionsByCategory(category));
		
		return new ResponseEntity<ResponseStructure<List<Question>>>(responseStructure, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Question>>> getQuestionsByDifficultyLevel(DifficultyLevel difficultyLevel) {
		ResponseStructure<List<Question>> responseStructure = new ResponseStructure<List<Question>>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("OK");
		responseStructure.setData(quizAppDao.getQuestionsByDifficultyLevel(difficultyLevel));
		
		return new ResponseEntity<ResponseStructure<List<Question>>>(responseStructure, HttpStatus.OK);
	}

}
