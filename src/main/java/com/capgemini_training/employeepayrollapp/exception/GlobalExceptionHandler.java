package com.capgemini_training.employeepayrollapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //method to handle name field validation exception
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleException(MethodArgumentNotValidException exception){
        FieldError fieldError = exception.getFieldError();
        assert fieldError != null;
        return new ResponseEntity<>(fieldError.getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }
}
