package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.mapper.GenreMapper;
import com.alkemy.disney.repository.specifications.GenreRepository;
import com.alkemy.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreMapper genreMapper;

    @Autowired
    private GenreRepository genreRepository;


    public GenreDTO postGenre(GenreDTO genreDto) {
        GenreEntity genreEntity = genreMapper.genreDTOToEntity(genreDto);
        GenreEntity entitySaved = genreRepository.save(genreEntity);
        return genreMapper.genreEntityToDTO(entitySaved);
    }

    @Override
    public GenreDTO putGenre(Long id, GenreDTO newDto) {
        Optional<GenreEntity> genreEntity = genreRepository.findById(id);
        if (!genreEntity.isPresent()) {
            System.out.println("Genre ID not valid");
        }
        genreMapper.genreEntityDataUpdate(genreEntity.get(), newDto);
        GenreEntity entitySaved = genreRepository.save(genreEntity.get());
        return genreMapper.genreEntityToDTO(entitySaved);

    }

    @Override
    public void deleteGenre(Long id) {
        this.genreRepository.deleteById(id);
    }

    @Override
    public GenreDTO getGenreById(Long genreId) {
        Optional<GenreEntity> genreEntity = this.genreRepository.findById(genreId);
        if (!genreEntity.isPresent()) {
            System.out.println("Genre ID not valid");
        }
        return genreMapper.genreEntityToDTO(genreEntity.get());
    }




}
