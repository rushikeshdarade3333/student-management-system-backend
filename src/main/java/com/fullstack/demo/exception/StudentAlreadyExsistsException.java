package com.fullstack.demo.exception;

public class StudentAlreadyExsistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentAlreadyExsistsException(String message) {
		super(message);
	}
}
