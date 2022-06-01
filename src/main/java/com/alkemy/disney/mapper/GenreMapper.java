package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.entity.GenreEntity;

import java.util.ArrayList;
import java.util.List;

public class GenreMapper {

    public static GenreEntity genreDTOToEntity(GenreDTO genreDto){
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setImage(genreDto.getImage());
        genreEntity.setName(genreDto.getName());
        return genreEntity;
    }

    public static GenreDTO genreEntityToDTO(GenreEntity genreEntity){
        GenreDTO genreDto = new GenreDTO();
        genreDto.setId(genreEntity.getId());
        genreDto.setImage(genreEntity.getImage());
        genreDto.setName(genreEntity.getName());
        return genreDto;
    }

    public static void genreEntityDataUpdate(GenreEntity entity, GenreDTO dto){
        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
    }

    public static List<GenreDTO> entityListToDTOList(List<GenreEntity> genreEntityList){
        List<GenreDTO> genreDtoList = new ArrayList<>();

        for (GenreEntity entity: genreEntityList) {
            genreDtoList.add(GenreMapper.genreEntityToDTO(entity));
        }
        return genreDtoList;
    }
}
