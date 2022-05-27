package com.alkemy.disney.controller;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.service.impl.CharacterService;
import java.util.Set;
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
    CharacterService characterService;
    
    @GetMapping
    public ResponseEntity<Set<CharacterDTO>> getAllCharacters() throws Exception {
       
        Set<CharacterDTO> characterList = characterService.getAllCharacters();
        HttpStatus statusCode;
        if(characterList.isEmpty()) {
            statusCode = HttpStatus.NO_CONTENT;
        } else {
            statusCode = HttpStatus.OK;
        }
        return new ResponseEntity<>(characterList, statusCode);

    }
}
