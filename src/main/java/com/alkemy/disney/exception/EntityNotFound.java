package com.alkemy.disney.exception;

public class EntityNotFound extends RuntimeException {
    
    public EntityNotFound(Class entity) {
        super(entity.getSimpleName() + " not found");
    }
    public EntityNotFound(String message) {
        super(message);
    }
    
}
