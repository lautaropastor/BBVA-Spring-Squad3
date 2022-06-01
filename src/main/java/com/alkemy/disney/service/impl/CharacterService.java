package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterDetailsDTO;
import com.alkemy.disney.dto.CharacterFullDTO;
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
    public Set<CharacterDTO> getAllCharacters(){
        List<CharacterEntity> charactersFull = characterRepository.findAll();
        Set<CharacterDTO> characterList = CharacterMapper.toSetDTO(charactersFull);
        return characterList;
    }

    @Override
    @Transactional
    public CharacterDetailsDTO getCharacterById(Long id){
        CharacterEntity characterEntity = characterRepository.getById(id);
        CharacterDetailsDTO characterDetails = CharacterMapper.toDetailsDTO(characterEntity);
        return characterDetails;
    }

    @Override
    @Transactional
    public CharacterFullDTO saveCharacter(CharacterDetailsDTO newCharacter){
        CharacterEntity characterEntity = CharacterMapper.detailsDTOtoEntity(newCharacter);
        CharacterEntity characterEntitySaved = characterRepository.save(characterEntity);
        CharacterFullDTO characterFullDTO = CharacterMapper.toFullDTO(characterEntitySaved);
        return characterFullDTO;
    }

    @Override
    @Transactional
    public CharacterFullDTO totalUpdateCharacter(CharacterFullDTO characterWithChanges){
        CharacterEntity characterEntity = CharacterMapper.fullDTOtoEntity(characterWithChanges);
        CharacterEntity updatedCharacter = characterRepository.save(characterEntity);
        CharacterFullDTO characterFullDTO = CharacterMapper.toFullDTO(updatedCharacter);
        return characterFullDTO;       
    }

    @Override
    @Transactional
    public boolean deleteCharacter(Long id){
        if(!characterRepository.existsById(id)) {
            return false;
        }
        //characterRepository.removeParticipationsCharacter(id); línea para borrado físico
        characterRepository.deleteById(id);
        return true;
    }
    
    
}
