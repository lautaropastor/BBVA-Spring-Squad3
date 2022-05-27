package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterDetailsDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.mapper.CharacterMapper;
import com.alkemy.disney.repository.specifications.CharacterRepository;
import com.alkemy.disney.service.ICharacterService;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService implements ICharacterService{
    
    @Autowired
    CharacterRepository characterRepository;

    @Override
    @Transactional
    public Collection<CharacterDTO> getAllCharacters() throws Exception {
        List<CharacterEntity> charactersFull = characterRepository.findAll();
        Collection<CharacterDTO> characterList = CharacterMapper.toSetDTO(charactersFull);
        return characterList;
    }

    @Override
    @Transactional
    public CharacterDetailsDTO getCharacterById(Long id) throws Exception {
        CharacterEntity characterEntity = characterRepository.getById(id);
        CharacterDetailsDTO characterDetails = CharacterMapper.toDetailsDTO(characterEntity);
        return characterDetails;
    }
    
    
    
}
