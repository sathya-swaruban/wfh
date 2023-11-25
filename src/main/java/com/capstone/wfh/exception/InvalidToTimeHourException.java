package com.capstone.wfh.exception;

public class InvalidToTimeHourException extends RuntimeException {
    public InvalidToTimeHourException() {
        super("ERROR: Provided to-time hour is greater than current time hour.");
    }
}
