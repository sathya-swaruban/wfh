package com.capstone.wfh.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@SuppressWarnings(value = "all")
public class ApiExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<String> handleException(RuntimeException exception){
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }

}