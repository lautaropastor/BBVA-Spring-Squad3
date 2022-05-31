package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.*;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.mapper.CharacterMapper;
import com.alkemy.disney.mapper.MovieMapper;
import com.alkemy.disney.repository.specifications.CharacterRepository;
import com.alkemy.disney.repository.specifications.MovieRepository;
import com.alkemy.disney.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public Set<MovieDTO> getMovies() {
        Set<MovieDTO> listMoviesDto = MovieMapper.toSetDTO(movieRepository.findAll());
        return listMoviesDto;
    }

    @Override
    public MovieFullDTO getMovieById(Long id) {
        MovieEntity movie = movieRepository.findById(id).orElseThrow();
        return MovieMapper.toFullDTO(movie);
    }

    @Override
    public void deleteMovieById (Long id) {
        boolean exist = movieRepository.existsById(id);
        if(!exist) {
            throw new NullPointerException();
        }
        movieRepository.deleteById(id);
    }

    @Override
    public MovieCharacterWithoutMoviesDTO postMovie (MovieDetailsDTO movieDTO) {
        Set<CharacterEntity> characters = getListWithExistsEntities(movieDTO.getCharacters());
        movieDTO.setCharacters(characters);
        MovieEntity movie = MovieMapper.toEntity(movieDTO);
        MovieEntity movieSaved = movieRepository.save(movie);
        return MovieMapper.toMovieCharacterWithoutMoviesDTO(movieSaved);
    }

    @Override
    public MovieFullDTO putMovie (Long id, MovieWithoutCharactersDTO movieWithoutCharactersDTO) {
        MovieEntity movieEntity = movieRepository.getById(id);
        MovieMapper.movieEntityDataUpdate(movieWithoutCharactersDTO, movieEntity);
        MovieEntity movieSaved = movieRepository.save(movieEntity);
        return MovieMapper.toFullDTO(movieSaved);
    }

    @Override
    public MovieCharacterWithoutMoviesDTO postCharacterInMovie (Long idMovie, Long idCharacter) {
            MovieEntity movie = movieRepository.getById(idMovie);
            CharacterEntity character = characterRepository.getById(idCharacter);
            MovieMapper.addCharacterInMovie(movie, character);
            movieRepository.save(movie);
        return MovieMapper.toMovieCharacterWithoutMoviesDTO(movie);
    }

    private Set<CharacterEntity> getListWithExistsEntities(Set<CharacterEntity> list) {
        Set<CharacterEntity> characters = new HashSet<>();
        for (CharacterEntity character : list) {
            if(character.getId() != null) {
                Long idCharacter = character.getId();
                characters.add(characterRepository.getById(idCharacter));
            } else {
                characters.add(character);
            }
        }
        return characters;
    }
}
