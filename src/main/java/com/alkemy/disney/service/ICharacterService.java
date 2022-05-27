package com.alkemy.disney.service;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterDetailsDTO;
import java.util.Collection;
import java.util.Optional;


public interface ICharacterService {
    public Collection<CharacterDTO> getAllCharacters() throws Exception;
    
    public CharacterDetailsDTO getCharacterById(Long id) throws Exception;
}
