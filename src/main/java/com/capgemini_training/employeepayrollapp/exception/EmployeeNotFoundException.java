package com.capgemini_training.employeepayrollapp.exception;

//custom exception
public class EmployeeNotFoundException extends RuntimeException{
    //constructor
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
