package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.MovieDTO;
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

    public List<MovieDTO> getMovies() {
        List<MovieDTO> listMoviesDto= MovieMapper.toListDto((List<MovieEntity>) movieRepository.findAll());
        return listMoviesDto;
    }

    public MovieDTO getMovieById(Long id) {
        MovieEntity movie = movieRepository.findById(id).orElseThrow();
        return MovieMapper.toDTO(movie);
    }

    public void deleteMovieById (Long id) {
        boolean exist = movieRepository.existsById(id);
        if(!exist) {
            throw new NullPointerException();
        }
        movieRepository.deleteById(id);
    }
}
