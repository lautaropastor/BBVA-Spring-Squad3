package com.alkemy.disney.controller;

import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/disney/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping()
    public List<MovieDTO> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping(path = "{id}")
    public MovieDTO getMovieById (@PathVariable Long id) {
        return movieService.getMovieById(id);
    }
}
