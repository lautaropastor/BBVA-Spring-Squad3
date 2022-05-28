package com.alkemy.disney.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CharacterWithoutMoviesDTO implements Serializable {
    private Long id;
    private String image;
    private String name;
    private String history;
    private Integer age;
    private Double weight;
}
