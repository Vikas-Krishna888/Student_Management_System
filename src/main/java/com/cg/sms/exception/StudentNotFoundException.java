package com.cg.sms.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StudentNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String message) {
		super(message);
	}

}
