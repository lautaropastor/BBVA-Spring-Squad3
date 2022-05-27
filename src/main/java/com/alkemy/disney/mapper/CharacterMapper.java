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
        CharacterDetailsDTO characterFullDTO = new CharacterDetailsDTO();
        characterFullDTO.setId(character.getId());
        characterFullDTO.setImage(character.getImage());
        characterFullDTO.setName(character.getName());
        characterFullDTO.setAge(character.getAge());
        characterFullDTO.setWeight(character.getWeight());
        characterFullDTO.setHistory(character.getHistory());
        Set<MovieEntity> listaParcial = new HashSet<>();
//        for (MovieEntity movie:character.getMovies()) {
//            listaParcial.add(new MovieEntity(movie.getId(),movie.getTitle(), movie.getImage(), movie.getRealasedDate(), movie.getCalification()));
//        }
        characterFullDTO.setMovies(listaParcial);
        //characterFullDTO.setMovies(character.getMovies());

        return characterFullDTO;
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

    public static CharacterEntity toEntity (CharacterDetailsDTO characterFullDTO) {
        if (characterFullDTO == null) {
            return null;
        }
        CharacterEntity character = new CharacterEntity();
        character.setId(characterFullDTO.getId());
        character.setImage(characterFullDTO.getImage());
        character.setName(characterFullDTO.getName());
        character.setAge(characterFullDTO.getAge());
        character.setWeight(characterFullDTO.getWeight());
        character.setHistory(characterFullDTO.getHistory());
        character.setMovies(characterFullDTO.getMovies());

        return character;
    }

    public static Set<CharacterDetailsDTO> toListFullDTO (List<CharacterEntity> setEntities) {
        Set<CharacterDetailsDTO> characterDTOSet = new HashSet<>();

        for (CharacterEntity character : setEntities) {
            characterDTOSet.add(toDetailsDTO(character));
        }
        return characterDTOSet;
    }

    public static Collection<CharacterDTO> toListDTO (List<CharacterEntity> setEntities) {
        Collection<CharacterDTO> charactersDTOSet = new HashSet<>();

        for (CharacterEntity character : setEntities) {
            charactersDTOSet.add(toDTO(character));
        }

        return charactersDTOSet;
    }

    public static List<CharacterDetailsDTO> toListCharacterDetails (List<CharacterEntity> list) {
        List<CharacterDetailsDTO> dtoList = new ArrayList<>();
        for (CharacterEntity character: list) {
            dtoList.add(toDetailsDTO(character));
        }
        return dtoList;
    }
}
