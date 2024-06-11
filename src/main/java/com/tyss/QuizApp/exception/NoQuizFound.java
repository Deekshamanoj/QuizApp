package com.tyss.QuizApp.exception;

public class NoQuizFound extends RuntimeException {

	private String message="NO QUIZ FOUND";

	public NoQuizFound()
	{

	}
	public NoQuizFound(String message)
	{
		this.message=message;
	}

}
