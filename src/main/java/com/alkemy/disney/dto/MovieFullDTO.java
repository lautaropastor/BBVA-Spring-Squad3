package com.alkemy.disney.dto;

import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.GenreEntity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public final class MovieFullDTO {
    private Long id;
    private String title;
    private String image;
    private Date realasedDate;
    private Integer calification;
    private GenreEntity genre; 
    private Set<CharacterWithoutMoviesDTO> characters = new HashSet<>();    
}
