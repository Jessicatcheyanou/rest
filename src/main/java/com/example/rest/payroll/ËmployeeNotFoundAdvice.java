package com.example.rest.payroll;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ËmployeeNotFoundAdvice {
    /*signals that this advice is rendered straight into the response body*/
    @ResponseBody

    /*configures the advice to only respond is an EmployeeNotFoundException is thrown*/
    @ExceptionHandler(EmployeeNotFoundException.class)

    /*says to issue an HttpStatus.NOT_FOUND ie an HTTP 404*/
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(EmployeeNotFoundException ex){
        return ex.getMessage();
    }
}
