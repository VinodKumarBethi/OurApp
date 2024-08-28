package com.example.app.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorClass> NotFoundExceptionHandler(NotFoundException ex){
		String exception=ex.getMessage();
		
		ErrorClass errorClass=new ErrorClass(exception,HttpStatus.NOT_FOUND);
		return new ResponseEntity<ErrorClass>(errorClass,HttpStatus.NOT_FOUND);
		
	}

}