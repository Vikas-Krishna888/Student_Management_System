package com.cg.sms.advice;

import java.util.LinkedHashMap;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.sms.exception.DepartmentNotFoundException;
import com.cg.sms.exception.StudentNotFoundException;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleBadRequest(MethodArgumentNotValidException ex){
		Map<String,String> errors=new LinkedHashMap<>();
		ex.getFieldErrors().stream().forEach(fieldError->{
			errors.put(fieldError.getField(),fieldError.getDefaultMessage());
		});
		return errors;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(StudentNotFoundException.class)
	public String handleNotFoundException(StudentNotFoundException ex) {
		return ex.getMessage();
	}
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(DepartmentNotFoundException.class)
	public String handleNotFoundException(DepartmentNotFoundException ex) {
		return ex.getMessage();
	}
}
