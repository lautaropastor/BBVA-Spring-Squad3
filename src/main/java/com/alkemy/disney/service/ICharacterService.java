package com.alkemy.disney.service;

import com.alkemy.disney.dto.CharacterSimpleDTO;
import com.alkemy.disney.dto.CharacterDetailsDTO;
import com.alkemy.disney.dto.CharacterWithoutMoviesDTO;
import java.util.Set;


public interface ICharacterService {
    public Set<CharacterSimpleDTO> getAllCharacters();
    
    public CharacterDetailsDTO getCharacterById(Long id);
    
    public CharacterDetailsDTO saveCharacter(CharacterDetailsDTO newCharacter);
    
    public CharacterDetailsDTO totalUpdateCharacter(Long id, CharacterWithoutMoviesDTO updatedCharacter);
    
    public boolean deleteCharacter(Long id);
}
