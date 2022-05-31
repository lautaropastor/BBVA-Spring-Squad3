package com.alkemy.disney.service;

import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.dto.MovieDetailsDTO;
import com.alkemy.disney.dto.MovieFullDTO;
import com.alkemy.disney.dto.MovieWithoutCharactersDTO;

import java.util.List;
import java.util.Set;

public interface IMovieService {

    Set<MovieDTO> getMovies();
    MovieFullDTO getMovieById(Long id);
    void deleteMovieById(Long id);
    MovieFullDTO postMovie(MovieDetailsDTO movie);
    MovieFullDTO putMovie(Long id, MovieWithoutCharactersDTO movieWithoutCharactersDTO);
}
