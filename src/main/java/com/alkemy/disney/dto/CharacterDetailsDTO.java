package com.alkemy.disney.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.alkemy.disney.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter @Setter
public class CharacterDetailsDTO implements Serializable {
    @NotEmpty(message = "must be completed")
    private String image;
    @NotEmpty(message = "must be completed")
    private String name;
    @NotEmpty(message = "must be completed")
    private String history;
    @NotNull(message = "must be completed") @Positive(message = "Age cannot be negative")
    private Integer age;
    @NotNull(message = "must be completed") @Positive(message = "Wieght must be positive")
    private Double weight;
    private Set<MovieEntity> movies = new HashSet<>();
}
