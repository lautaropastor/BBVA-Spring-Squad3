package com.alkemy.disney.service;

import com.alkemy.disney.dto.GenreDTO;

import java.util.List;

public interface GenreService {
    GenreDTO postGenre (GenreDTO dto);
    GenreDTO putGenre (Long id, GenreDTO dto);
    GenreDTO getGenreById(Long genreId);
    void deleteGenre (Long id);



}
