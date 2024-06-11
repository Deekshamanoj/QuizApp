package com.tyss.QuizApp.exception;

public class NoQuestionsFoundInDataBase extends RuntimeException {
	
	private String message="NO QUESTIONS";
	
	public NoQuestionsFoundInDataBase()
	{
		
	}
	public NoQuestionsFoundInDataBase(String message)
	{
		this.message=message;
	}

}
