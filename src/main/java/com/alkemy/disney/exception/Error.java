package com.alkemy.disney.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Error {
    GENERAL("Error occurred, " + Error.mensajeBásico),
    DATA_INTEGRITY("Constraint Error occurred, " + Error.mensajeBásico),
    INVALID_ARGUMENT("invalid argument, " + Error.mensajeBásico);

    private String message;
    private final static String mensajeBásico = "The request could not be processed";


}
