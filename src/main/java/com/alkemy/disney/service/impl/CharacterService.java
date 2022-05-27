package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.mapper.CharacterMapper;
import com.alkemy.disney.repository.specifications.CharacterRepository;
import com.alkemy.disney.service.ICharacterService;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService implements ICharacterService{
    
    @Autowired
    CharacterRepository characterRepository;

    @Override
    @Transactional
    public Set<CharacterDTO> getAllCharacters() throws Exception {
        List<CharacterEntity> charactersFull = characterRepository.findAll();
        Set<CharacterDTO> characterList = CharacterMapper.toListDTO(charactersFull);
        return characterList;
    }
    
}
