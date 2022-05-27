package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.dto.MovieWithoutCharactersDTO;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.mapper.MovieMapper;
import com.alkemy.disney.repository.specifications.MovieRepository;
import com.alkemy.disney.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieMapper movieMapper;

    public List<MovieDTO> getMovies() {
        List<MovieDTO> listMoviesDto= movieMapper.toListDto((List<MovieEntity>) movieRepository.findAll());
        return listMoviesDto;
    }

    public MovieDTO getMovieById(Long id) {
        MovieEntity movie = movieRepository.findById(id).orElseThrow();
        return movieMapper.toDTO(movie);
    }

    public void deleteMovieById (Long id) {
        boolean exist = movieRepository.existsById(id);
        if(!exist) {
            throw new NullPointerException();
        }
        movieRepository.deleteById(id);
    }

    public MovieDTO postMovie (MovieDTO movieDTO) {
        MovieEntity movie = movieMapper.toEntity(movieDTO);
        MovieEntity movieSaved = movieRepository.save(movie);
        return movieMapper.toDTO(movieSaved);
    }

    public MovieDTO putMovie (Long id, MovieWithoutCharactersDTO movieWithoutCharactersDTO) {
        MovieEntity movieEntity = movieRepository.findById(id).orElseThrow();
        movieMapper.movieEntityDataUpdate(movieWithoutCharactersDTO, movieEntity);
        MovieEntity movieSaved = movieRepository.save(movieEntity);
        return movieMapper.toDTO(movieSaved);
    }
}
