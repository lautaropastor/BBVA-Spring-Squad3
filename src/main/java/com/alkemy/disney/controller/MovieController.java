package com.alkemy.disney.controller;

import com.alkemy.disney.dto.*;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import javax.validation.Valid;

@RestController
@RequestMapping("/disney/api/movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping()
    public ResponseEntity<Set<MovieSimpleDTO>> getMovies() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetailsDTO> getMovieById (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.getMovieById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletedDTO> deleteMovieById (@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new DeletedDTO(MovieEntity.class));
    }

    @PostMapping
    public ResponseEntity<MovieDetailsDTO> postMovie (@Valid @RequestBody MovieDetailsDTO movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.postMovie(movie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDetailsDTO> putMovie (@PathVariable Long id,@RequestBody MovieWithoutCharactersDTO movie) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.putMovie(id, movie));
    }

    @PostMapping("/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<MovieDetailsDTO> postCharacterInMovie (@PathVariable Long idMovie, @PathVariable Long idCharacter) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.postCharacterInMovie(idMovie, idCharacter));
    }
    
    @DeleteMapping("/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<DeletedDTO> removeCharacterInMovie (@PathVariable Long idMovie, @PathVariable Long idCharacter) {
        movieService.removeCharacterInMovie(idMovie, idCharacter);
        return ResponseEntity.status(HttpStatus.OK).body(new DeletedDTO(CharacterEntity.class));
    }
}
