package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterWithoutMoviesDTO;
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

    public static CharacterDetailsDTO toDetailsDTO(CharacterEntity character) {
        if (character == null) {
            return null;
        }
        CharacterDetailsDTO characterDetailsDTO = new CharacterDetailsDTO();
        characterDetailsDTO.setImage(character.getImage());
        characterDetailsDTO.setName(character.getName());
        characterDetailsDTO.setAge(character.getAge());
        characterDetailsDTO.setWeight(character.getWeight());
        characterDetailsDTO.setHistory(character.getHistory());
        characterDetailsDTO.setMovies(character.getMovies());

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

    public static CharacterFullDTO toFullDTO (CharacterEntity character){
        CharacterFullDTO characterFullDTO = new CharacterFullDTO();
        characterFullDTO.setId(character.getId());
        characterFullDTO.setImage(character.getImage());
        characterFullDTO.setName(character.getName());
        characterFullDTO.setAge(character.getAge());
        characterFullDTO.setWeight(character.getWeight());
        characterFullDTO.setHistory(character.getHistory());
        characterFullDTO.setMovies(character.getMovies());

        return characterFullDTO;
    }

    public static CharacterEntity detailsDTOtoEntity (CharacterDetailsDTO characterDetailsDTO) {
        if (characterDetailsDTO == null) {
            return null;
        }
        CharacterEntity character = new CharacterEntity();
//        character.setId(characterDetailsDTO.getId());
        character.setImage(characterDetailsDTO.getImage());
        character.setName(characterDetailsDTO.getName());
        character.setAge(characterDetailsDTO.getAge());
        character.setWeight(characterDetailsDTO.getWeight());
        character.setHistory(characterDetailsDTO.getHistory());
        character.setMovies(characterDetailsDTO.getMovies());

        return character;
    }

    public static CharacterEntity fullDTOtoEntity (CharacterFullDTO characterFullDTO) {
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

    public static Set<CharacterWithoutMoviesDTO> toListCharacterWitouhMoviesDto (Set<CharacterEntity> list) {
        Set<CharacterWithoutMoviesDTO> listCharacterWitouhtMovies = new HashSet<>();
        for (CharacterEntity character : list) {
            listCharacterWitouhtMovies.add(toWithoutMoviesDTO(character));
        }
        return listCharacterWitouhtMovies;
    }
    
    public static void characterEntityDataUpdate(CharacterWithoutMoviesDTO characterWithoutMoviesDTO, CharacterEntity characterEntity) {
        characterEntity.setName(characterWithoutMoviesDTO.getName());
        characterEntity.setImage(characterWithoutMoviesDTO.getImage());
        characterEntity.setWeight(characterWithoutMoviesDTO.getWeight());
        characterEntity.setAge(characterWithoutMoviesDTO.getAge());
        characterEntity.setHistory(characterWithoutMoviesDTO.getHistory());
    }
}