package com.alkemy.disney.service;

import com.alkemy.disney.dto.*;

import java.util.Set;

public interface IMovieService {

    Set<MovieSimpleDTO> getMovies();
    MovieDetailsDTO getMovieById(Long id);
    void deleteMovieById(Long id);
    MovieDetailsDTO postMovie(MovieDetailsDTO movie);
    MovieDetailsDTO putMovie(Long id, MovieWithoutCharactersDTO movieWithoutCharactersDTO);
    MovieDetailsDTO postCharacterInMovie(Long idMovie, Long idCharacter);
    boolean removeCharacterInMovie(Long idMovie, Long idCharacter);
}
