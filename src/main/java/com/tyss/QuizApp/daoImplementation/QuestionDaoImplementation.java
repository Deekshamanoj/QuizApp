package com.tyss.QuizApp.daoImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.QuizApp.dao.QuestionDao;
import com.tyss.QuizApp.entity.Question;
import com.tyss.QuizApp.enums.DifficultyLevel;
import com.tyss.QuizApp.exception.NoQuestionsFoundInDataBase;
import com.tyss.QuizApp.repository.QuestionRepository;

@Repository
public class QuestionDaoImplementation implements QuestionDao{

	@Autowired
	private QuestionRepository quizAppRepository ;
	
	@Override
	public Question saveQuestion(Question question) {
		return quizAppRepository.save(question);
	}

	@Override
	public List<Question> getAllQuestion() {
		List<Question> list_questions= quizAppRepository.findAll();
		if(!list_questions.isEmpty())
			return list_questions ;
		throw new NoQuestionsFoundInDataBase("NO QUESTIONS IN DATABASE");
	}

	@Override
	public List<Question> getQuestionsByCategory(String category) {
		return quizAppRepository.findByCategory(category);
	}

	@Override
	public List<Question> getQuestionsByDifficultyLevel(DifficultyLevel difficultyLevel) {
		return quizAppRepository.findByDifficultyLevel(difficultyLevel);
	}

	@Override
	public List<Question> getRandomQuestionByCategoryAndDifficultyLevel(String category,
			DifficultyLevel difficultyLevel, int numQue) {
		return quizAppRepository.findByCategoryAndDifficultylevel(category,difficultyLevel,numQue);
	}

}
