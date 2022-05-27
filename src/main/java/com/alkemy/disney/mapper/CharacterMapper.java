package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterDetailsDTO;
import com.alkemy.disney.dto.CharacterFullDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;

import java.util.ArrayList;
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
       /* for (MovieEntity movie:character.getMovies()) {
            listaParcial.add(new MovieEntity(movie.getId(),movie.getTitle(), movie.getImage(), movie.getRealasedDate(), movie.getCalification()));
        }
        characterFullDTO.setMovies(listaParcial);*/
        //characterFullDTO.setMovies(character.getMovies());

        return characterFullDTO;
    }

    public static CharacterDetailsDTO toDetailsDTO (CharacterEntity character) {
        CharacterDetailsDTO characterDetailsDTO = new CharacterDetailsDTO();
        characterDetailsDTO.setId(character.getId());
        characterDetailsDTO.setImage(character.getImage());
        characterDetailsDTO.setName(character.getName());
        characterDetailsDTO.setAge(character.getAge());
        characterDetailsDTO.setWeight(character.getWeight());
        characterDetailsDTO.setHistory(character.getHistory());

        return characterDetailsDTO;
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

    public static List<CharacterDetailsDTO> toListCharacterDetails (List<CharacterEntity> list) {
        List<CharacterDetailsDTO> dtoList = new ArrayList<>();
        for (CharacterEntity character: list) {
            dtoList.add(toDetailsDTO(character));
        }
        return dtoList;
    }
    public static Set<CharacterDetailsDTO> toListCharacterDetails (Set<CharacterEntity> list) {
        Set<CharacterDetailsDTO> dtoList = new HashSet<>();
        for (CharacterEntity character: list) {
            dtoList.add(toDetailsDTO(character));
        }
        return dtoList;
    }

    public static Set<CharacterEntity> toListEntity (Set<CharacterDetailsDTO> characterDetailsDTOS) {
        Set<CharacterEntity> characterEntities = new HashSet<>();
        for (CharacterDetailsDTO characterDetailsDTO : characterDetailsDTOS) {
            characterEntities.add(toEntity(characterDetailsDTO));
        }
        return  characterEntities;
    }
}
