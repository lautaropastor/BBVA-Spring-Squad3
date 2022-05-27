package com.alkemy.disney.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler( value = {ApiRequestException.class})
    public ResponseEntity<Object> handlerApiRequestException(ApiRequestException e){
        ApiException apiException = new ApiException(
                e.getMessage(),
                e.getStatusRequest()
        );

        return new ResponseEntity<>(apiException, e.getStatusRequest());
    }
}
