package com.alkemy.disney.service;

import com.alkemy.disney.dto.MovieDTO;

import java.util.List;
import java.util.Set;

public interface MovieService {

    List<MovieDTO> getMovies();
    MovieDTO getMovieById(Long id);
}
