package com.example.droneAPI.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class RequestNotFoundException extends RuntimeException{
    public RequestNotFoundException(String message, RequestNotFoundException e, HttpStatus badRequest, ZonedDateTime z) {
        super(message);
    }

    public RequestNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestNotFoundException(Throwable cause) {
        super(cause);
    }

    public RequestNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


    public RequestNotFoundException() {
    }

    public RequestNotFoundException(String message) {
        super(message);
    }
}
