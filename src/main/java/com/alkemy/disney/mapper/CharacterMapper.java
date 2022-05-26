package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterFullDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CharacterMapper {

    public static CharacterDTO toDTO (CharacterEntity character) {
        if (character == null) {
            return null;
        }
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName(character.getName());
        characterDTO.setImage(character.getImage());

        return characterDTO;
    }

    public static CharacterFullDTO toFullDTO(CharacterEntity character) {
        if (character == null) {
            return null;
        }
        CharacterFullDTO characterFullDTO = new CharacterFullDTO();
        characterFullDTO.setId(character.getId());
        characterFullDTO.setImage(character.getImage());
        characterFullDTO.setName(character.getName());
        characterFullDTO.setAge(character.getAge());
        characterFullDTO.setWeight(character.getWeight());
        characterFullDTO.setHistory(character.getHistory());
        Set<MovieEntity> listaParcial = new HashSet<>();
        for (MovieEntity movie:character.getMovies()) {
            listaParcial.add(new MovieEntity(movie.getId(),movie.getTitle(), movie.getImage(), movie.getRealasedDate(), movie.getCalification()));
        }
        characterFullDTO.setMovies(listaParcial);
        //characterFullDTO.setMovies(character.getMovies());

        return characterFullDTO;
    }

    public static CharacterEntity toEntity (CharacterFullDTO characterFullDTO) {
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

    public static Set<CharacterFullDTO> toListFullDTO (List<CharacterEntity> setEntities) {
        Set<CharacterFullDTO> characterDTOSet = new HashSet<>();

        for (CharacterEntity character : setEntities) {
            characterDTOSet.add(toFullDTO(character));
        }
        return characterDTOSet;
    }

    public static Set<CharacterDTO> toListDTO (List<CharacterEntity> setEntities) {
        Set<CharacterDTO> charactersDTOSet = new HashSet<>();

        for (CharacterEntity character : setEntities) {
            charactersDTOSet.add(toDTO(character));
        }

        return charactersDTOSet;
    }
}
