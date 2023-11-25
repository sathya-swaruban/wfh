package com.capstone.wfh.exception;

public class InvalidToTimeMinuteException extends RuntimeException {
    public InvalidToTimeMinuteException() {
        super("ERROR: Provided to-time minute is greater than current time minute.");
    }
}
