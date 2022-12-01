package com.example.droneAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseStatus
public class RestResponseExceptionHandler extends Throwable{
    @ExceptionHandler({RequestNotFoundException.class})
    public ResponseEntity<ErrorMessage> userNotFoundExcweption(RequestNotFoundException Exception, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, Exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorMessage> notReadable(HttpMessageNotReadableException Exception, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, "Not readable json");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<ErrorMessage> nullException(NullPointerException Exception, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, "Handle nulls in payload");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
}
