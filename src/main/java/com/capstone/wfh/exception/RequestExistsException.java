package com.capstone.wfh.exception;

public class RequestExistsException extends RuntimeException {
    public RequestExistsException(String message) {
        super(message);
    }
}
