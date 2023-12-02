package com.capstone.wfh.handler;

import com.capstone.wfh.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@SuppressWarnings(value = "all")
public class ApiExceptionHandler {

    @ExceptionHandler(DifferentDatesException.class)
    protected ResponseEntity<String> handleDifferentDatesException(DifferentDatesException exception){
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }

    @ExceptionHandler(InvalidDatesException.class)
    protected ResponseEntity<String> handleInvalidDatesException(InvalidDatesException exception){
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }

    @ExceptionHandler(InvalidTimeRangeException.class)
    protected ResponseEntity<String> handleInvalidTimeRangeException(InvalidTimeRangeException exception){
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }

    @ExceptionHandler(InvalidToTimeHourException.class)
    protected ResponseEntity<String> handleInvalidToTimeHourException(InvalidToTimeHourException exception){
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }

    @ExceptionHandler(InvalidToTimeMinuteException.class)
    protected ResponseEntity<String> handleInvalidToTimeMinuteException(InvalidToTimeMinuteException exception){
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }

    @ExceptionHandler(RequestExistsException.class)
    protected ResponseEntity<String> handleRequestExistsException(RequestExistsException exception){
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }

    @ExceptionHandler(WeekendException.class)
    protected ResponseEntity<String> handleWeekendException(WeekendException exception){
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }

}