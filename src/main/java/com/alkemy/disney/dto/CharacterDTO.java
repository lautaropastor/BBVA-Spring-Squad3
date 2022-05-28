package com.alkemy.disney.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class CharacterDTO implements Serializable {
    private Long id;
    @NotEmpty(message = "must be completed")
    private String name;
    @NotEmpty(message = "must be completed")
    private String image; 
}
