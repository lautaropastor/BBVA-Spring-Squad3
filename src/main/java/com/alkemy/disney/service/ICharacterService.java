package com.alkemy.disney.service;

import com.alkemy.disney.dto.CharacterDTO;
import java.util.Set;


public interface ICharacterService {
    public Set<CharacterDTO> getAllCharacters() throws Exception;
}
