package com.alkemy.disney.service;

import com.alkemy.disney.dto.*;
import com.alkemy.disney.exception.EntityAlreadyExists;

import java.util.List;
import java.util.Set;

public interface IMovieService {

    Set<MovieDTO> getMovies();
    MovieFullDTO getMovieById(Long id);
    void deleteMovieById(Long id);
    MovieCharacterWithoutMoviesDTO postMovie(MovieDetailsDTO movie);
    MovieFullDTO putMovie(Long id, MovieWithoutCharactersDTO movieWithoutCharactersDTO);
    MovieCharacterWithoutMoviesDTO postCharacterInMovie(Long idMovie, Long idCharacter);
    boolean removeCharacterInMovie(Long idMovie, Long idCharacter);
}
