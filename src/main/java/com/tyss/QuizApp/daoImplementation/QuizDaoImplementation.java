package com.tyss.QuizApp.daoImplementation;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tyss.QuizApp.dao.QuizDao;
import com.tyss.QuizApp.entity.Quiz;
import com.tyss.QuizApp.exception.NoQuizFound;
import com.tyss.QuizApp.repository.QuizRepository;


@Repository
public class QuizDaoImplementation implements QuizDao{

	@Autowired
	private QuizRepository quizRepository ;

	@Override
	public Quiz saveQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> findAll() {
		return quizRepository.findAll();
	}

	@Override
	public Quiz findById(int id) {
		Optional<Quiz> op=quizRepository.findById(id);
		if(op.isPresent())
			return op.get();
		throw new NoQuizFound("No Quiz Foud With given ID");
	}



}
