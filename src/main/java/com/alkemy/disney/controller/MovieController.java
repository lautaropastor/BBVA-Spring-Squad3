package com.alkemy.disney.controller;

import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.dto.MovieWithoutCharactersDTO;
import com.alkemy.disney.entity.MovieEntity;
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

    @PostMapping()
    public MovieDTO postMovie (@RequestBody MovieDTO movie) {
        return movieService.postMovie(movie);
    }

    @PutMapping(path = "{id}")
    public MovieDTO putMovie (@PathVariable Long id,@RequestBody MovieWithoutCharactersDTO movie) {
        return movieService.putMovie(id, movie);
    }
}
