package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterSimpleDTO;
import com.alkemy.disney.dto.CharacterWithoutMoviesDTO;
import com.alkemy.disney.dto.CharacterDetailsDTO;
import com.alkemy.disney.dto.MovieWithoutCharactersDTO;
import com.alkemy.disney.entity.CharacterEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CharacterMapper {

    public static CharacterSimpleDTO toDTO (CharacterEntity character) {
        if (character == null) {
            return null;
        }
        CharacterSimpleDTO characterDTO = new CharacterSimpleDTO();
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
        Set<MovieWithoutCharactersDTO> movies = new HashSet<>();
        character.getMovies().forEach(movie -> {
            MovieWithoutCharactersDTO movieWithoutCharactersDTO = MovieMapper.toWithoutCharactersDTO(movie);
            movies.add(movieWithoutCharactersDTO);
        });
        characterDetailsDTO.setMovies(movies);

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


    public static CharacterEntity detailsDTOtoEntity (CharacterDetailsDTO characterDetailsDTO) {
        if (characterDetailsDTO == null) {
            return null;
        }
        CharacterEntity character = new CharacterEntity();
        character.setImage(characterDetailsDTO.getImage());
        character.setName(characterDetailsDTO.getName());
        character.setAge(characterDetailsDTO.getAge());
        character.setWeight(characterDetailsDTO.getWeight());
        character.setHistory(characterDetailsDTO.getHistory());

        return character;
    }

    public static CharacterEntity withoutMoviesDTOtoEntity (CharacterWithoutMoviesDTO characterWithoutMoviesDTO) {
        if (characterWithoutMoviesDTO == null) {
            return null;
        }
        CharacterEntity character = new CharacterEntity();
        character.setImage(characterWithoutMoviesDTO.getImage());
        character.setName(characterWithoutMoviesDTO.getName());
        character.setAge(characterWithoutMoviesDTO.getAge());
        character.setWeight(characterWithoutMoviesDTO.getWeight());
        character.setHistory(characterWithoutMoviesDTO.getHistory());

        return character;
    }

    public static Set<CharacterDetailsDTO> toListFullDTO (List<CharacterEntity> setEntities) {
        Set<CharacterDetailsDTO> characterDTOSet = new HashSet<>();

        for (CharacterEntity character : setEntities) {
            characterDTOSet.add(toDetailsDTO(character));
        }
        return characterDTOSet;
    }

    public static Set<CharacterSimpleDTO> toSetDTO (List<CharacterEntity> setEntities) {
        Set<CharacterSimpleDTO> charactersDTOSet = new HashSet<>();

        for (CharacterEntity character : setEntities) {
            charactersDTOSet.add(toDTO(character));
        }

        return charactersDTOSet;
    }

    public static List<CharacterSimpleDTO> toListDTO (List<CharacterEntity> setEntities) {
        List<CharacterSimpleDTO> charactersDTOList = new ArrayList<>();

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