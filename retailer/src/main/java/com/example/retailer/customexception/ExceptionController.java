package com.example.retailer.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Error> NotFoundExceptionHandler(NotFoundException ex){
		String exception=ex.getMessage();
		
		Error errorClass=new Error(new ErrorClass(exception,HttpStatus.NOT_FOUND));
		return new ResponseEntity<Error>(errorClass,HttpStatus.NOT_FOUND);
		
	}

}
