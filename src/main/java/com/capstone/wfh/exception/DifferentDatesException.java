package com.capstone.wfh.exception;

public class DifferentDatesException extends RuntimeException {
    public DifferentDatesException() {
        super("ERROR: Provided from-date and to-date are different.");
    }
}
