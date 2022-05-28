package com.alkemy.disney.service;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterDetailsDTO;
import com.alkemy.disney.dto.CharacterFullDTO;
import java.util.Collection;


public interface ICharacterService {
    public Collection<CharacterDTO> getAllCharacters() throws Exception;
    
    public CharacterDetailsDTO getCharacterById(Long id) throws Exception;
    
    public CharacterFullDTO saveCharacter(CharacterDetailsDTO newCharacter) throws Exception;
    
    public CharacterFullDTO totalUpdateCharacter(CharacterFullDTO updatedCharacter) throws Exception;
    
    public boolean deleteCharacter(Long id) throws Exception;
}
