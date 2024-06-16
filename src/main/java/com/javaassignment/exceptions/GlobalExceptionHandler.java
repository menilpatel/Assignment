package com.javaassignment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.javaassignment.response.ObjectResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<?> handleMissingServletRequestParameter(MissingServletRequestParameterException ex) {
		return new ResponseEntity<>(
				new ObjectResponse(400, false, "Missing required parameter: " + ex.getParameterName(), null),
				HttpStatus.BAD_REQUEST);
	}

}
