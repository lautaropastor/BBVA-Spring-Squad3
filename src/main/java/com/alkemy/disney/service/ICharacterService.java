package com.alkemy.disney.service;

import com.alkemy.disney.dto.CharacterDTO;
import java.util.Collection;


public interface ICharacterService {
    public Collection<CharacterDTO> getAllCharacters() throws Exception;
}
