package com.alkemy.disney.controller;

import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disney/api/movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping()
    public List<MovieDTO> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping(path = "{id}")
    public MovieDTO getMovieById (@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteMovieById (@PathVariable Long id) {movieService.deleteMovieById(id);}
}
