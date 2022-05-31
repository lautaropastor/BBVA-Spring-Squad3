package com.alkemy.disney.dto;

import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.GenreEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class MovieCharacterWithoutMoviesDTO {
    private Long id;
    private String title;
    private String image;
    private Date realasedDate;
    private Integer calification;
    private GenreEntity genre;
    private Set<CharacterWithoutMoviesDTO> charactersWithoutMovies = new HashSet<>();
}
