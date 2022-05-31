package com.alkemy.disney.controller;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/disney/api/genres")
public class GenreController {


    @Autowired()
    private GenreService genreService;

    @PostMapping
    public ResponseEntity<GenreDTO> postGenre(@Valid @RequestBody GenreDTO genreDto){
        GenreDTO postGenre = genreService.postGenre(genreDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(postGenre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreDTO> putGenre(@PathVariable Long id, @Valid @RequestBody GenreDTO genreDto){
        GenreDTO putGenre = genreService.putGenre(id, genreDto);
        return ResponseEntity.ok().body(putGenre);
    }

    @GetMapping
    public ResponseEntity<List<GenreDTO>> getGenres(){
        List<GenreDTO> genreDtoList = genreService.getAllGenres();
        return ResponseEntity.ok().body(genreDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> getGenreById(@PathVariable Long id){
        GenreDTO getGenre = genreService.getGenreById(id);
        return ResponseEntity.ok().body(getGenre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable Long id)  {
        genreService.deleteGenre(id);
        return ResponseEntity.ok().body("Genre Deleted");
    }



}
