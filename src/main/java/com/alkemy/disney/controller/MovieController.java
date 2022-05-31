package com.alkemy.disney.controller;

import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.dto.MovieDetailsDTO;
import com.alkemy.disney.dto.MovieFullDTO;
import com.alkemy.disney.dto.MovieWithoutCharactersDTO;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/disney/api/movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping()
    public ResponseEntity<Set<MovieDTO>> getMovies() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovies());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<MovieFullDTO> getMovieById (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.getMovieById(id));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteMovieById (@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping()
    public ResponseEntity<MovieFullDTO> postMovie (@RequestBody MovieDetailsDTO movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.postMovie(movie));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<MovieFullDTO> putMovie (@PathVariable Long id,@RequestBody MovieWithoutCharactersDTO movie) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.putMovie(id, movie));
    }
}
