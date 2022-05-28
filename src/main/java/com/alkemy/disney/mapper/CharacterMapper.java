package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterWithoutMoviesDTO;
import com.alkemy.disney.dto.CharacterDetailsDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CharacterMapper {

    public static CharacterDTO toDTO (CharacterEntity character) {
        if (character == null) {
            return null;
        }
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(character.getId());
        characterDTO.setName(character.getName());
        characterDTO.setImage(character.getImage());

        return characterDTO;
    }

    public static CharacterDetailsDTO toDetailsDTO(CharacterEntity character) {
        if (character == null) {
            return null;
        }
        CharacterDetailsDTO characterDetailsDTO = new CharacterDetailsDTO();
        characterDetailsDTO.setId(character.getId());
        characterDetailsDTO.setImage(character.getImage());
        characterDetailsDTO.setName(character.getName());
        characterDetailsDTO.setAge(character.getAge());
        characterDetailsDTO.setWeight(character.getWeight());
        characterDetailsDTO.setHistory(character.getHistory());
        Set<MovieEntity> listaParcial = new HashSet<>();
//        for (MovieEntity movie:character.getMovies()) {
//            listaParcial.add(new MovieEntity(movie.getId(),movie.getTitle(), movie.getImage(), movie.getRealasedDate(), movie.getCalification()));
//        }
        characterDetailsDTO.setMovies(listaParcial);
        //characterFullDTO.setMovies(character.getMovies());

        return characterDetailsDTO;
    }

    public static CharacterWithoutMoviesDTO toWithoutMoviesDTO (CharacterEntity character){
        CharacterWithoutMoviesDTO characterWithoutMoviesDTO = new CharacterWithoutMoviesDTO();
        characterWithoutMoviesDTO.setId(character.getId());
        characterWithoutMoviesDTO.setImage(character.getImage());
        characterWithoutMoviesDTO.setName(character.getName());
        characterWithoutMoviesDTO.setAge(character.getAge());
        characterWithoutMoviesDTO.setWeight(character.getWeight());
        characterWithoutMoviesDTO.setHistory(character.getHistory());

        return characterWithoutMoviesDTO;
    }

    public static CharacterEntity toEntity (CharacterDetailsDTO characterDetailsDTO) {
        if (characterDetailsDTO == null) {
            return null;
        }
        CharacterEntity character = new CharacterEntity();
        character.setId(characterDetailsDTO.getId());
        character.setImage(characterDetailsDTO.getImage());
        character.setName(characterDetailsDTO.getName());
        character.setAge(characterDetailsDTO.getAge());
        character.setWeight(characterDetailsDTO.getWeight());
        character.setHistory(characterDetailsDTO.getHistory());
        character.setMovies(characterDetailsDTO.getMovies());

        return character;
    }

    public static Set<CharacterDetailsDTO> toListFullDTO (List<CharacterEntity> setEntities) {
        Set<CharacterDetailsDTO> characterDTOSet = new HashSet<>();

        for (CharacterEntity character : setEntities) {
            characterDTOSet.add(toDetailsDTO(character));
        }
        return characterDTOSet;
    }

    public static Set<CharacterDTO> toSetDTO (List<CharacterEntity> setEntities) {
        Set<CharacterDTO> charactersDTOSet = new HashSet<>();

        for (CharacterEntity character : setEntities) {
            charactersDTOSet.add(toDTO(character));
        }

        return charactersDTOSet;
    }
    
    public static List<CharacterDTO> toListDTO (List<CharacterEntity> setEntities) {
        List<CharacterDTO> charactersDTOList = new ArrayList<>();

        for (CharacterEntity character : setEntities) {
            charactersDTOList.add(toDTO(character));
        }

        return charactersDTOList;
    }

    public static Set<CharacterDetailsDTO> toListCharacterDetails (Set<CharacterEntity> list) {
        Set<CharacterDetailsDTO> dtoList = new HashSet<>();
        for (CharacterEntity character: list) {
            dtoList.add(toDetailsDTO(character));
        }
        return dtoList;
    }
}
