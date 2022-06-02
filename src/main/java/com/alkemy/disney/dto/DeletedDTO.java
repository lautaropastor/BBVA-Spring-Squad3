package com.alkemy.disney.dto;

import lombok.Getter;

@Getter
public class DeletedDTO {
    private final boolean DELETED = true;
    private String message;

    public DeletedDTO (Class entity) {
        message = "The " + entity.getSimpleName() + " was deleted succesfully";
    }
}
