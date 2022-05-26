package com.alkemy.disney.service;

import com.alkemy.disney.dto.MovieDTO;

import java.util.Set;

public interface MovieService {

    Set<MovieDTO> getMovies();
}
