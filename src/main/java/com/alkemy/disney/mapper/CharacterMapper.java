package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.entity.MovieEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CharacterMapper {

    public static CharacterDTO toDTO (CharacterEntity character) {
        if (character == null) {
            return null;
        }
        CharacterDTO characterFullDTO = new CharacterDTO();
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

    public static CharacterEntity toEntity (CharacterDTO characterDTO) {
        if (characterDTO == null) {
            return null;
        }
        CharacterEntity character = new CharacterEntity();
        character.setId(characterDTO.getId());
        character.setImage(characterDTO.getImage());
        character.setName(characterDTO.getName());
        character.setAge(characterDTO.getAge());
        character.setWeight(characterDTO.getWeight());
        character.setHistory(characterDTO.getHistory());
        character.setMovies(characterDTO.getMovies());

        return character;
    }

    public static Set<CharacterDTO> toListDTO (List<CharacterEntity> setEntities) {
        Set<CharacterDTO> characterDTOSet = new HashSet<>();

        for (CharacterEntity character : setEntities) {
            characterDTOSet.add(toDTO(character));
        }
        return characterDTOSet;
    }
}
