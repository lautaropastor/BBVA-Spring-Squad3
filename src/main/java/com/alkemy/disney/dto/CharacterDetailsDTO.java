package com.alkemy.disney.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import org.hibernate.validator.constraints.URL;

@Getter @Setter
public class CharacterDetailsDTO implements Serializable {
    private Long id;
    @NotBlank(message = "must be completed") 
    @URL(message = "URL is not valid")
    @Pattern(regexp = ".*(png|jpg|jpeg|gif)$", message = "is not a valid format")
    private String image;
    @NotBlank(message = "must be completed")
    private String name;
    @NotBlank(message = "must be completed")
    private String history;
    @NotNull(message = "must be completed") @Positive(message = "must be positive")
    private Integer age;
    @NotNull(message = "must be completed") @Positive(message = "must be positive")
    private Double weight;
    private Set<MovieWithoutCharactersDTO> movies = new HashSet<>();
}
