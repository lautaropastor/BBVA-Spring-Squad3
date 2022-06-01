package com.alkemy.disney.service;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterDetailsDTO;
import com.alkemy.disney.dto.CharacterFullDTO;
import java.util.Set;


public interface ICharacterService {
    public Set<CharacterDTO> getAllCharacters();
    
    public CharacterDetailsDTO getCharacterById(Long id);
    
    public CharacterFullDTO saveCharacter(CharacterDetailsDTO newCharacter);
    
    public CharacterFullDTO totalUpdateCharacter(CharacterFullDTO updatedCharacter);
    
    public boolean deleteCharacter(Long id);
}
