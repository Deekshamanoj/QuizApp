package com.tyss.QuizApp.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.tyss.QuizApp.dao.QuestionDao;
import com.tyss.QuizApp.dao.QuizDao;
import com.tyss.QuizApp.dto.QuestionDto;
import com.tyss.QuizApp.dto.Response;
import com.tyss.QuizApp.dto.ResponseStructure;
import com.tyss.QuizApp.entity.Question;
import com.tyss.QuizApp.entity.Quiz;
import com.tyss.QuizApp.enums.DifficultyLevel;
import com.tyss.QuizApp.service.QuizService;

@Service
public class QuizServiceImplementation implements QuizService{

	@Autowired
	private QuestionDao questionDao ;

	@Autowired
	private QuizDao quizDao ;

	@Override
	public ResponseEntity<ResponseStructure<Quiz>> createQuiz(String category, DifficultyLevel difficultyLevel,
			int numQue, String title) {

		Quiz quiz = new Quiz() ;
		quiz.setTitle(title);

		List<Question> list_question=questionDao.getRandomQuestionByCategoryAndDifficultyLevel(category,difficultyLevel,numQue);

		quiz.setList_questions(list_question);
		quiz.setTotalQue(list_question.size());

		ResponseStructure<Quiz> responseStructure = new ResponseStructure<Quiz>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("CREATED");
		responseStructure.setData(quizDao.saveQuiz(quiz));

		return new ResponseEntity<ResponseStructure<Quiz>>(responseStructure,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Quiz>>> getAllQuiz() {
		ResponseStructure<List<Quiz>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("OK");
		responseStructure.setData(quizDao.findAll());

		return new ResponseEntity<ResponseStructure<List<Quiz>>>(responseStructure,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Quiz>> getQuizById(int id) {
		ResponseStructure<Quiz> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("OK");
		responseStructure.setData(quizDao.findById(id));

		return new ResponseEntity<ResponseStructure<Quiz>>(responseStructure,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<QuestionDto>>> getQuizQuestionsById(int id) {
		List<Question> list_question=quizDao.findById(id).getList_questions();
		List<QuestionDto> list =   new ArrayList<QuestionDto>();
		for(Question q : list_question)
		{
			QuestionDto questionDto = new QuestionDto(q.getId(),q.getCategory(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			list.add(questionDto);
		}
		ResponseStructure<List<QuestionDto>> responseStructure = new ResponseStructure<List<QuestionDto>>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(list);
		responseStructure.setMessage("OK");
		return new ResponseEntity<ResponseStructure<List<QuestionDto>>>(responseStructure,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Integer>> calculateResult(int id, List<Response> response) {
		Quiz quiz = quizDao.findById(id);
		List<Question> list_questions = quiz.getList_questions();
		int right_answer = 0 ;
		int i = 0 ;
		for(Response r : response)
		{
			if(r.getResponse().equals(list_questions.get(i).getRightOption()))
					right_answer++;
			i++;
		}
		
		ResponseStructure<Integer> responseStructure = new ResponseStructure<Integer>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("OK");
		responseStructure.setData(right_answer);
		
		return new ResponseEntity<ResponseStructure<Integer>>(responseStructure,HttpStatus.OK);
	}

}
