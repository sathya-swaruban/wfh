package com.capstone.wfh.exception;

public class InvalidTimeRangeException extends RuntimeException {
    public InvalidTimeRangeException() {
        super("ERROR: Provided from-time should be less than to-time.");
    }
}
