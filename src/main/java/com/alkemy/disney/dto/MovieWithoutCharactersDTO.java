package com.alkemy.disney.dto;

import com.alkemy.disney.entity.GenreEntity;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class MovieWithoutCharactersDTO {
    private Long id;
    private String title;
    private String image;
    private Date realasedDate;
    private Integer calification;
    private GenreEntity genre;   
}
