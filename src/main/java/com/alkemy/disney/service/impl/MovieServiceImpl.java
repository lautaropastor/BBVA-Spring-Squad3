package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.repository.specifications.MovieRepository;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Set<MovieDTO> getMovies() {
        movieRepository.findAll();
    }
}
