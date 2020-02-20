package com.geekyants.mailengine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.geekyants.mailengine.dto.ErrorDto;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDto> NoEntriesException(NoEntriesException ex) {

		ErrorDto errorResponse = new ErrorDto();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatusCode(0001);
		return new ResponseEntity<ErrorDto>(errorResponse, HttpStatus.OK);
	}
public ResponseEntity<ErrorDto> NotFoundException(NotFoundException ex) {

	ErrorDto errorResponse = new ErrorDto();
	errorResponse.setMessage(ex.getMessage());
	errorResponse.setStatusCode(0002);
	return new ResponseEntity<ErrorDto>(errorResponse, HttpStatus.OK);
}
public ResponseEntity<ErrorDto> InValidCustomerException(InValidCustomerException ex) {

	ErrorDto errorResponse = new ErrorDto();
	errorResponse.setMessage(ex.getMessage());
	errorResponse.setStatusCode(0003);
	return new ResponseEntity<ErrorDto>(errorResponse, HttpStatus.OK);
}
}
