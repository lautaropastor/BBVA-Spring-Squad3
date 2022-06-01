package com.alkemy.disney.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class CharacterSimpleDTO implements Serializable {
    private Long id;
    private String name;
    private String image; 
}
