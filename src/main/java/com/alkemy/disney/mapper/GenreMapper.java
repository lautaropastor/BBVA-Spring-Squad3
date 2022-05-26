package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.entity.GenreEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenreMapper {

    public GenreEntity genreDTOToEntity(GenreDTO genreDto){
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setImage(genreDto.getImage());
        genreEntity.setName(genreDto.getName());
        return genreEntity;
    }

    public GenreDTO genreEntityToDTO(GenreEntity genreEntity){
        GenreDTO genreDto = new GenreDTO();
        genreDto.setId(genreEntity.getId());
        genreDto.setImage(genreEntity.getImage());
        genreDto.setName(genreEntity.getName());
        return genreDto;
    }

    
}
