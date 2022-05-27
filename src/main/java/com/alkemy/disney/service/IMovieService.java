package com.alkemy.disney.service;

import com.alkemy.disney.dto.MovieDTO;

import java.util.List;

public interface IMovieService {

    List<MovieDTO> getMovies();
    MovieDTO getMovieById(Long id);
    void deleteMovieById(Long id);
}
