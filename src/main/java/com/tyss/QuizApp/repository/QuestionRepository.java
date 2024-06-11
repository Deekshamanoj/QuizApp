package com.tyss.QuizApp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.QuizApp.entity.Question;
import com.tyss.QuizApp.enums.DifficultyLevel;

public interface QuestionRepository  extends JpaRepository<Question, Integer>{

	List<Question> findByCategory(String category);

	List<Question> findByDifficultyLevel(DifficultyLevel difficultyLevel);

	@Query("SELECT q FROM Question q WHERE q.category=:category AND q.difficultyLevel=:difficultyLevel ORDER BY RANDOM() LIMIT:numQue")
	List<Question> findByCategoryAndDifficultylevel(String category, DifficultyLevel difficultyLevel,int numQue);

}
