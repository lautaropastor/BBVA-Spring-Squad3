package com.alkemy.disney.service;

import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.dto.MovieWithoutCharactersDTO;

import java.util.List;

public interface IMovieService {

    List<MovieDTO> getMovies();
    MovieDTO getMovieById(Long id);
    void deleteMovieById(Long id);
    MovieDTO postMovie(MovieDTO movie);
    MovieDTO putMovie(Long id, MovieWithoutCharactersDTO movieWithoutCharactersDTO);
}
