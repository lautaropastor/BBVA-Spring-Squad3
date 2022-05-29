package com.alkemy.disney.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class CharacterWithoutMoviesDTO implements Serializable {
    private Long id;
    @NotEmpty(message = "must be completed")
    private String image;
    @NotEmpty(message = "must be completed")
    private String name;
    @NotEmpty(message =  "must be completed")
    private String history;
    @NotNull(message = "must be completed")
    private Integer age;
    @NotNull(message = "must be completed")
    private Double weight;
}
