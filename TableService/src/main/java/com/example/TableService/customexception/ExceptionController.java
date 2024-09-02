package com.example.TableService.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Error> NotFoundExceptionHandler(NotFoundException ex) {
		String exception = ex.getMessage();

		Error errorClass = new Error(new ErrorClass(exception, HttpStatus.NOT_FOUND));
		return new ResponseEntity<Error>(errorClass, HttpStatus.NOT_FOUND);

	}

	// @ExceptionHandler(Exception.class)
	// public ResponseEntity<ErrorClass> genericExceptionHandler(Exception ex) {
	// 	String exception = ex.getMessage();

	// 	ErrorClass error =  new ErrorClass(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	// 	return new ResponseEntity<ErrorClass>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	// }
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> genericExceptionHandler(Exception ex) {
		String exception = ex.getMessage();

		Error error = new Error( new ErrorClass(exception, HttpStatus.INTERNAL_SERVER_ERROR));
		return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
