package com.alkemy.disney.controller;

import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/disney/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping()
    public Set<MovieDTO> getMovies() {
        return movieService.getMovies();
    }
}
