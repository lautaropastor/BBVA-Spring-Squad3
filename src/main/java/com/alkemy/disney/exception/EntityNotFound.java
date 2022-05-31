package com.alkemy.disney.exception;

public class EntityNotFound extends RuntimeException {
    
    public EntityNotFound(Class entity, String message) {
        super(entity.getSimpleName() + " " + message);
    }
    
}
