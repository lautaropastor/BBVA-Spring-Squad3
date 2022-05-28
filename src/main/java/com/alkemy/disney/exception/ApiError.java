package com.alkemy.disney.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@Getter
public class ApiError2 {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "Date: dd-MM-yyyy Time: hh:mm:ss")
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiError2(LocalDateTime timestamp, HttpStatus status, String message, List<String> errors) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiError2(LocalDateTime timestamp, HttpStatus status, String message, String error) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }
}