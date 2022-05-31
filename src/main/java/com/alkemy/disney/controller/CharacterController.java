package com.alkemy.disney.controller;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterDetailsDTO;
import com.alkemy.disney.dto.CharacterFullDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.service.ICharacterService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/disney/api/characters")
public class CharacterController {
    
    @Autowired
    ICharacterService characterService;
    
    @GetMapping
    public ResponseEntity<Collection<CharacterDTO>> getAllCharacters(){
       
        Collection<CharacterDTO> characterList = characterService.getAllCharacters();
        
        HttpStatus statusCode = (characterList.isEmpty()) ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        
        return new ResponseEntity<>(characterList, statusCode);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CharacterDetailsDTO> getCharacterById(@PathVariable Long id){
        
        CharacterDetailsDTO character = characterService.getCharacterById(id);
        
        return ResponseEntity.ok().body(character);
    }
    
    @PostMapping
    public ResponseEntity<CharacterFullDTO> postCharacter(@Valid @RequestBody CharacterDetailsDTO newCharacter) {
        
        CharacterFullDTO characterSaved = characterService.saveCharacter(newCharacter);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(characterSaved);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CharacterFullDTO> updateCharacter(@PathVariable Long id, @Valid @RequestBody CharacterFullDTO characterWithChanges){
        
        CharacterDetailsDTO characterToUpdate = characterService.getCharacterById(id);
        
        characterWithChanges.setId(id);
        characterWithChanges.setMovies(characterToUpdate.getMovies());
        
        CharacterFullDTO characterUpdated = characterService.totalUpdateCharacter(characterWithChanges); 
        
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(characterUpdated);
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCharacter(@PathVariable Long id){
        
        Boolean isDeleted = characterService.deleteCharacter(id);
        
        HttpStatus statusCode = isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        
        return ResponseEntity.status(statusCode).body(isDeleted);
    }
    
    // TODO: @PatchMapping
    
}
