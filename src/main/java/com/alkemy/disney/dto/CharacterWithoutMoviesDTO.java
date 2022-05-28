package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CharacterWithoutMoviesDTO {
    private Long id;
    private String image;
    private String name;
    private String history;
    private Integer age;
    private Double weight;
}
