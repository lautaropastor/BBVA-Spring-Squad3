package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.*;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.exception.EntityAlreadyExists;
import com.alkemy.disney.exception.EntityNotFound;
import com.alkemy.disney.mapper.GenreMapper;
import com.alkemy.disney.mapper.MovieMapper;
import com.alkemy.disney.repository.specifications.CharacterRepository;
import com.alkemy.disney.repository.specifications.GenreRepository;
import com.alkemy.disney.repository.specifications.MovieRepository;
import com.alkemy.disney.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CharacterRepository characterRepository;
    
    @Autowired
    private GenreRepository genreRepository;
    
    @Override
    public Set<MovieSimpleDTO> getMovies() {
        Set<MovieSimpleDTO> listMoviesDto = MovieMapper.toSetDTO(movieRepository.findAll());
        return listMoviesDto;
    }

    @Override
    public MovieDetailsDTO getMovieById(Long id) {
        MovieEntity movie = movieRepository.findById(id).orElseThrow(() -> new EntityNotFound(MovieEntity.class));
        return MovieMapper.toDetailsDTO(movie);
    }

    @Override
    public void deleteMovieById (Long id) {
        boolean exist = movieRepository.existsById(id);
        if(!exist) {
            throw new EntityNotFound(MovieEntity.class);
        }
        movieRepository.deleteById(id);
    }

    @Override
    public MovieDetailsDTO postMovie (MovieDetailsDTO movieDTO) {
//        Set<CharacterEntity> characters = getListWithExistsEntities(movieDTO.getCharacters());
//        movieDTO.setCharacters(characters);
        MovieEntity movie = MovieMapper.toEntity(movieDTO);
        MovieEntity movieSaved = movieRepository.save(movie);
        MovieDetailsDTO movieDetailsSaved = MovieMapper.toDetailsDTO(movieSaved);
        GenreDTO genreDTO = GenreMapper.genreEntityToDTO(genreRepository.getById(movieDTO.getGenre().getId()));
        movieDetailsSaved.setGenre(genreDTO);
        return movieDetailsSaved;
    }

    @Override
    public MovieDetailsDTO putMovie (Long id, MovieWithoutCharactersDTO movieWithoutCharactersDTO) {
        MovieEntity movieEntity = movieRepository.findById(id).orElseThrow(() -> new EntityNotFound(MovieEntity.class));
        MovieMapper.movieEntityDataUpdate(movieWithoutCharactersDTO, movieEntity);
        GenreEntity genreEntity = genreRepository.findById(movieWithoutCharactersDTO.getGenre().getId()).orElseThrow(() -> new EntityNotFound(GenreEntity.class));
        movieEntity.setGenre(genreEntity);
        MovieEntity movieSaved = movieRepository.save(movieEntity);
        return MovieMapper.toDetailsDTO(movieSaved);
    }

    @Override
    public MovieDetailsDTO postCharacterInMovie (Long idMovie, Long idCharacter) {
        if(!movieRepository.existsById(idMovie)) throw new EntityNotFound(MovieEntity.class);
        
        if(!characterRepository.existsById(idCharacter)) throw new EntityNotFound(CharacterEntity.class);
       
        MovieEntity movie = movieRepository.getById(idMovie);
        CharacterEntity character = characterRepository.getById(idCharacter);
        
        if(movie.getCharacters().contains(character)) throw new EntityAlreadyExists(CharacterEntity.class ,idCharacter + " was already added to the movie");
      
        movie.addCharacter(character);
        movieRepository.save(movie);
        return MovieMapper.toDetailsDTO(movie);
    }

//    private Set<CharacterEntity> getListWithExistsEntities(Set<CharacterEntity> list) {
//        Set<CharacterEntity> characters = new HashSet<>();
//        for (CharacterEntity character : list) {
//            if(character.getId() != null) {
//                Long idCharacter = character.getId();
//                characters.add(characterRepository.getById(idCharacter));
//            } else {
//                characters.add(character);
//            }
//        }
//        return characters;
//    }

    @Override
    public boolean removeCharacterInMovie(Long idMovie, Long idCharacter) {
        MovieEntity movie = movieRepository.findById(idMovie).orElseThrow(() -> new EntityNotFound(MovieEntity.class));
        CharacterEntity characterToRemove = characterRepository.findById(idCharacter).orElseThrow(() -> new EntityNotFound(CharacterEntity.class));
        movie.removeCharacter(characterToRemove);
        movieRepository.save(movie);
        return true;
    }
}
