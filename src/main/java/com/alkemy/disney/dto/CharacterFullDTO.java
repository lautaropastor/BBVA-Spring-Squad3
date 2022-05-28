package com.alkemy.disney.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.alkemy.disney.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class CharacterFullDTO implements Serializable {
    // TODO: Crear el método correspondiente en el mapper
    private Long id;
    private String image;
    private String name;
    private String history;
    private Integer age;
    private Double weight;
    private Set<MovieEntity> movies = new HashSet<>();
}
