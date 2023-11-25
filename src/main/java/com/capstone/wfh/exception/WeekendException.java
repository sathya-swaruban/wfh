package com.capstone.wfh.exception;

public class WeekendException extends RuntimeException {
    public WeekendException() {
        super("ERROR: Provided from-date and to-date must not be a weekend.");
    }
}
