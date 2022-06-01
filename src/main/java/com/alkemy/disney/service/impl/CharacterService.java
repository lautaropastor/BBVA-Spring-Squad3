package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.CharacterSimpleDTO;
import com.alkemy.disney.dto.CharacterDetailsDTO;
import com.alkemy.disney.dto.CharacterWithoutMoviesDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.exception.EntityNotFound;
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
    public Set<CharacterSimpleDTO> getAllCharacters(){
        List<CharacterEntity> charactersFull = characterRepository.findAll();
        Set<CharacterSimpleDTO> characterList = CharacterMapper.toSetDTO(charactersFull);
        return characterList;
    }

    @Override
    @Transactional
    public CharacterDetailsDTO getCharacterById(Long id){
        CharacterEntity characterEntity = characterRepository.findById(id).orElseThrow(() -> new EntityNotFound(CharacterEntity.class));
        CharacterDetailsDTO characterDetails = CharacterMapper.toDetailsDTO(characterEntity);
        return characterDetails;
    }

    @Override
    @Transactional
    public CharacterDetailsDTO saveCharacter(CharacterDetailsDTO newCharacter){
        CharacterEntity characterEntity = CharacterMapper.detailsDTOtoEntity(newCharacter);
        CharacterEntity characterEntitySaved = characterRepository.save(characterEntity);
        CharacterDetailsDTO characterFullDTO = CharacterMapper.toDetailsDTO(characterEntitySaved);
        return characterFullDTO;
    }

    @Override
    @Transactional
    public CharacterDetailsDTO totalUpdateCharacter(Long id, CharacterWithoutMoviesDTO characterWithChanges){
        CharacterEntity characterToUpdate = characterRepository.findById(id).orElseThrow(() -> new EntityNotFound(CharacterEntity.class));
        CharacterMapper.characterEntityDataUpdate(characterWithChanges, characterToUpdate);
        CharacterEntity updatedCharacter = characterRepository.save(characterToUpdate);
        CharacterDetailsDTO characterFullDTO = CharacterMapper.toDetailsDTO(updatedCharacter);
        return characterFullDTO;       
    }

    @Override
    @Transactional
    public boolean deleteCharacter(Long id){
        if(!characterRepository.existsById(id)) {
            throw new EntityNotFound(CharacterEntity.class);
        }
        //characterRepository.removeParticipationsCharacter(id); línea para borrado físico
        characterRepository.deleteById(id);
        return true;
    }
    
    
}
