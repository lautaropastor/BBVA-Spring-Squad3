package com.alkemy.disney.controller;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.service.ICharacterService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disney/api/characters")
public class CharacterController {
    
    @Autowired
    ICharacterService characterService;
    
    @GetMapping
    public ResponseEntity<Collection<CharacterDTO>> getAllCharacters() throws Exception {
       
        Collection<CharacterDTO> characterList = characterService.getAllCharacters();
        
        HttpStatus statusCode = (characterList.isEmpty()) ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        
        return new ResponseEntity<>(characterList, statusCode);
    }
}
