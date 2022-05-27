package com.alkemy.disney.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiRequestException extends RuntimeException{

    private HttpStatus statusRequest;
    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, HttpStatus statusRequest) {
        super(message);
        this.statusRequest = statusRequest;
    }


}
