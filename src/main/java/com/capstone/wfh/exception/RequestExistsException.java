package com.capstone.wfh.exception;

public class RequestExistsException extends RuntimeException {
    public RequestExistsException() {
        super("ERROR: WFH Request already exists for the provided date.");
    }
}
