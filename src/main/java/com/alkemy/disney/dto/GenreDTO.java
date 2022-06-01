package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class GenreDTO {
    private Long id;
    @NotEmpty(message = "must be completed")
    private String name;
    private String image;

}
