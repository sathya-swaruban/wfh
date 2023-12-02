package com.capstone.wfh.exception;

public class InvalidDatesException extends RuntimeException {
    public InvalidDatesException() {
        super("ERROR: Provided dates should not exceed current date.");
    }
}
