package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.dto.MovieDetailsDTO;
import com.alkemy.disney.dto.MovieFullDTO;
import com.alkemy.disney.dto.MovieWithoutCharactersDTO;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.mapper.MovieMapper;
import com.alkemy.disney.repository.specifications.MovieRepository;
import com.alkemy.disney.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Set<MovieDTO> getMovies() {
        Set<MovieDTO> listMoviesDto = MovieMapper.toSetDTO(movieRepository.findAll());
        return listMoviesDto;
    }

    @Override
    public MovieFullDTO getMovieById(Long id) {
        MovieEntity movie = movieRepository.findById(id).orElseThrow();
        return MovieMapper.toFullDTO(movie);
    }

    @Override
    public void deleteMovieById (Long id) {
        boolean exist = movieRepository.existsById(id);
        if(!exist) {
            throw new NullPointerException();
        }
        movieRepository.deleteById(id);
    }

    @Override
    public MovieFullDTO postMovie (MovieDetailsDTO movieDTO) {
        MovieEntity movie = MovieMapper.toEntity(movieDTO);
        MovieEntity movieSaved = movieRepository.save(movie);
        return MovieMapper.toFullDTO(movieSaved);
    }

    @Override
    public MovieFullDTO putMovie (Long id, MovieWithoutCharactersDTO movieWithoutCharactersDTO) {
        MovieEntity movieEntity = movieRepository.findById(id).orElseThrow();
        // TODO: A revisar try catch
        try {
            MovieMapper.movieEntityDataUpdate(movieWithoutCharactersDTO, movieEntity);
        } catch (Exception ex) {
            Logger.getLogger(MovieServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        MovieEntity movieSaved = movieRepository.save(movieEntity);
        return MovieMapper.toFullDTO(movieSaved);
    }
}
