package com.alkemy.disney.service;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterDetailsDTO;
import com.alkemy.disney.dto.CharacterFullDTO;
import com.alkemy.disney.dto.CharacterWithoutMoviesDTO;
import java.util.Set;


public interface ICharacterService {
    public Set<CharacterDTO> getAllCharacters();
    
    public CharacterDetailsDTO getCharacterById(Long id);
    
    public CharacterFullDTO saveCharacter(CharacterDetailsDTO newCharacter);
    
    public CharacterFullDTO totalUpdateCharacter(Long id, CharacterWithoutMoviesDTO updatedCharacter);
    
    public boolean deleteCharacter(Long id);
}
