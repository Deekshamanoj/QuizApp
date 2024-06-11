package com.tyss.QuizApp.entity;

import com.tyss.QuizApp.enums.DifficultyLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	private String category ;
	@Enumerated(EnumType.STRING)
	private DifficultyLevel difficultyLevel;
	private String questionTitle ;
	private String option1 ;
	private String option2 ;
	private String option3 ;
	private String option4 ;
	private String rightOption ;
	

}

