package com.alkemy.disney.exception;

import javax.swing.text.html.parser.Entity;

public class EntityAlreadyExists extends RuntimeException {
    private String message;
    public EntityAlreadyExists(Class entity, String errorMessage) {
        message = (entity.getSimpleName() + " " + errorMessage);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
