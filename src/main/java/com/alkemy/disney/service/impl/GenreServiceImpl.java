package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.exception.EntityNotFound;
import com.alkemy.disney.mapper.GenreMapper;
import com.alkemy.disney.repository.specifications.GenreRepository;
import com.alkemy.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public GenreDTO postGenre(GenreDTO genreDto){
        GenreEntity genreEntity = GenreMapper.genreDTOToEntity(genreDto);
        GenreEntity entitySaved = genreRepository.save(genreEntity);
        return GenreMapper.genreEntityToDTO(entitySaved);
    }

    @Override
    public GenreDTO putGenre(Long genreId, GenreDTO newDto) {
        GenreEntity genreEntity = genreRepository.findById(genreId).orElseThrow(() -> new EntityNotFound(GenreEntity.class));
        GenreMapper.genreEntityDataUpdate(genreEntity, newDto);
        GenreEntity entitySaved = genreRepository.save(genreEntity);
        return GenreMapper.genreEntityToDTO(entitySaved);
    }

    @Override
    public void deleteGenre(Long genreId){
        GenreEntity genreEntity = genreRepository.findById(genreId).orElseThrow(() -> new EntityNotFound(GenreEntity.class));
        this.genreRepository.delete(genreEntity);
    }

    @Override
    public GenreDTO getGenreById(Long genreId){
        GenreEntity genreEntity = genreRepository.findById(genreId).orElseThrow(() -> new EntityNotFound(GenreEntity.class));
        return GenreMapper.genreEntityToDTO(genreEntity);
    }

    @Override
    public List<GenreDTO> getAllGenres() {
        List<GenreEntity> genreEntities = genreRepository.findAll();
        return GenreMapper.entityListToDTOList(genreEntities);
    }

}
