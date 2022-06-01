package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.*;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.entity.MovieEntity;
import java.util.HashSet;
import java.util.Set;

public final class MovieMapper {
    
    public static MovieEntity toEntity(MovieWithoutCharactersDTO movieWithoutCharactersDTO) {    
        if(movieWithoutCharactersDTO == null) {
            return null;
        }
        
        MovieEntity movieEntity = new MovieEntity();
        
        movieEntity.setId(movieWithoutCharactersDTO.getId());
        movieEntity.setTitle(movieWithoutCharactersDTO.getTitle());
        movieEntity.setImage(movieWithoutCharactersDTO.getImage());
        movieEntity.setRealasedDate(movieWithoutCharactersDTO.getRealasedDate());
        movieEntity.setCalification(movieWithoutCharactersDTO.getCalification());
        movieEntity.setGenre(GenreMapper.genreDTOToEntity(movieWithoutCharactersDTO.getGenre()));        
        return movieEntity;         
    }
    
    public static MovieEntity toEntity(MovieDetailsDTO movieDetailsDTO) {
        if(movieDetailsDTO == null) {
            return null;
        }
        
        MovieEntity movieEntity = new MovieEntity();
        
        movieEntity.setTitle(movieDetailsDTO.getTitle());
        movieEntity.setImage(movieDetailsDTO.getImage());
        movieEntity.setRealasedDate(movieDetailsDTO.getRealasedDate());
        movieEntity.setCalification(movieDetailsDTO.getCalification());
        
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setId(movieDetailsDTO.getGenre().getId());
        movieEntity.setGenre(genreEntity);
        
        Set<CharacterEntity> characters = new HashSet<>();
        movieDetailsDTO.getCharacters().forEach(character -> {
            CharacterEntity characterWithoutMovies = CharacterMapper.withoutMoviesDTOtoEntity(character);
            characters.add(characterWithoutMovies);
        });
        movieEntity.setCharacters(characters);

        return movieEntity;
    }

    public static MovieWithoutCharactersDTO toWithoutCharactersDTO(MovieEntity movieEntity) {
        if(movieEntity == null) {
            return null;
        }


        MovieWithoutCharactersDTO movieWithoutCharactersDTO = new MovieWithoutCharactersDTO();

        movieWithoutCharactersDTO.setId(movieEntity.getId());
        movieWithoutCharactersDTO.setTitle(movieEntity.getTitle());
        movieWithoutCharactersDTO.setImage(movieEntity.getImage());
        movieWithoutCharactersDTO.setRealasedDate(movieEntity.getRealasedDate());
        movieWithoutCharactersDTO.setCalification(movieEntity.getCalification());
        movieWithoutCharactersDTO.setGenre(GenreMapper.genreEntityToDTO(movieEntity.getGenre()));
        return movieWithoutCharactersDTO;
    }
    
        public static MovieDetailsDTO toDetailsDTO(MovieEntity movieEntity) {
        if(movieEntity == null) {
            return null;
        }

        MovieDetailsDTO movieDetailsDTO = new MovieDetailsDTO();

        movieDetailsDTO.setId(movieEntity.getId());
        movieDetailsDTO.setTitle(movieEntity.getTitle());
        movieDetailsDTO.setImage(movieEntity.getImage());
        movieDetailsDTO.setRealasedDate(movieEntity.getRealasedDate());
        movieDetailsDTO.setCalification(movieEntity.getCalification());
        movieDetailsDTO.setGenre(GenreMapper.genreEntityToDTO(movieEntity.getGenre()));
        Set<CharacterWithoutMoviesDTO> characters = new HashSet<>();
        movieEntity.getCharacters().forEach(character -> {
            CharacterWithoutMoviesDTO characterWithoutMovies = CharacterMapper.toWithoutMoviesDTO(character);
            characters.add(characterWithoutMovies);
        });
        movieDetailsDTO.setCharacters(characters);

        return movieDetailsDTO;
    }
    
    

    public static void movieEntityDataUpdate(MovieWithoutCharactersDTO movieWithoutCharactersDTO, MovieEntity movieEntity){

        movieEntity.setTitle(movieWithoutCharactersDTO.getTitle());
        movieEntity.setImage(movieWithoutCharactersDTO.getImage());
        movieEntity.setRealasedDate(movieWithoutCharactersDTO.getRealasedDate());
        movieEntity.setCalification(movieWithoutCharactersDTO.getCalification());
        // movieEntity.setGenre(GenreMapper.genreDTOToEntity(movieWithoutCharactersDTO.getGenre()));

    }

    public static MovieSimpleDTO toDTO(MovieEntity movieEntity) {
        if(movieEntity == null) return null;

        MovieSimpleDTO movieDTO = new MovieSimpleDTO();

        movieDTO.setId(movieEntity.getId());
        movieDTO.setTitle(movieEntity.getTitle());
        movieDTO.setImage(movieEntity.getImage());
        movieDTO.setRealasedDate(movieEntity.getRealasedDate());

        return movieDTO;

    }

    public static Set<MovieSimpleDTO> toSetDTO(Iterable<MovieEntity> movies) {
        Set<MovieSimpleDTO> moviesDTO = new HashSet();
        movies.forEach(movie -> {
            moviesDTO.add(MovieMapper.toDTO(movie));
        });
        return moviesDTO;
    }

    public static void addCharacterInMovie(MovieEntity movie, CharacterEntity character) {
        Set<CharacterEntity> charactersInMovie = movie.getCharacters();
        charactersInMovie.add(character);
    }
    
}
