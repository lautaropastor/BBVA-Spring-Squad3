package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.mapper.GenreMapper;
import com.alkemy.disney.repository.specifications.GenreRepository;
import com.alkemy.disney.service.GenreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private GenreMapper genreMapper;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public GenreDTO postGenre(GenreDTO genreDto){
        //GenreEntity genreEntity = genreMapper.genreDTOToEntity(genreDto);
        GenreEntity genreEntity = mapper.map(genreDto, GenreEntity.class);
        GenreEntity entitySaved = genreRepository.save(genreEntity);

        return genreMapper.genreEntityToDTO(entitySaved);
    }

    @Override
    public GenreDTO putGenre(Long genreId, GenreDTO newDto) {
        GenreEntity genreEntity = genreRepository.getById(genreId);
        genreMapper.genreEntityDataUpdate(genreEntity, newDto);
        GenreEntity entitySaved = genreRepository.save(genreEntity);
        return genreMapper.genreEntityToDTO(entitySaved);
    }

    @Override
    public void deleteGenre(Long genreId){
        GenreEntity genreEntity = genreRepository.getById(genreId);
        this.genreRepository.deleteById(genreId);
    }

    @Override
    public GenreDTO getGenreById(Long genreId){
        GenreEntity genreEntity = genreRepository.getById(genreId);
        return mapper.map(genreEntity, GenreDTO.class);
    }

    @Override
    public List<GenreDTO> getAllGenres() {
        List<GenreEntity> genreEntities = genreRepository.findAll();
        return genreMapper.entityListToDTOList(genreEntities);
    }




}
