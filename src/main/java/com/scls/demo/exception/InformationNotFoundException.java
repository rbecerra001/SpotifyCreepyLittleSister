package com.scls.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Creates a not found error (404) instead of a Internal Service error (500)
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class InformationNotFoundException extends RuntimeException{
    public InformationNotFoundException(String message){
        super(message);
    }
}
