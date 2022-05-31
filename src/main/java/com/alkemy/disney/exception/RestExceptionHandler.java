package com.alkemy.disney.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ Throwable.class })
    public ResponseEntity<Object> handleAll(Throwable ex,WebRequest request) {
        ApiError apiError = new ApiError(LocalDateTime.now(),HttpStatus.INTERNAL_SERVER_ERROR, request.getDescription(true),Error.GENERAL.getMessage(),  ex.getLocalizedMessage());
        return new ResponseEntity(apiError, apiError.getStatus());
    }

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
        String error = ex.getName() + " should be of type " + ex.getRequiredType().getSimpleName();
        ApiError apiError = new ApiError(LocalDateTime.now(),HttpStatus.BAD_REQUEST, request.getDescription(true),ex.getLocalizedMessage(), error);
        return new ResponseEntity(apiError, apiError.getStatus());
    }

    @Override
    public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        errors.add(ex.getMethod()+ " Method is not supported for this request. Supported Methods are: ");
        ex.getSupportedHttpMethods().forEach(t -> errors.add(t.toString()));
        ApiError apiError = new ApiError(LocalDateTime.now(),HttpStatus.METHOD_NOT_ALLOWED, request.getDescription(true),ex.getLocalizedMessage(), errors);
        return new ResponseEntity(apiError, apiError.getStatus());
    }



    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> errors = new ArrayList<>();
        fieldErrors.forEach(error -> errors.add("field " + error.getField() + " " + error.getDefaultMessage()));
        ApiError err = new ApiError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                request.getDescription(true),
                Error.INVALID_ARGUMENT.getMessage(),
                errors);
        return new ResponseEntity(err, err.getStatus());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex, WebRequest request) {
        String cause = ex.getMostSpecificCause().getMessage();
        ApiError err = new ApiError ( LocalDateTime.now(),HttpStatus.CONFLICT, request.getDescription(true), Error.DATA_INTEGRITY.getMessage(), cause );
        return new ResponseEntity(err, err.getStatus());
    }

}