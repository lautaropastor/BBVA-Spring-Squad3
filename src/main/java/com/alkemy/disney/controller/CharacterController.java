package com.alkemy.disney.controller;

import com.alkemy.disney.dto.CharacterSimpleDTO;
import com.alkemy.disney.dto.CharacterDetailsDTO;
import com.alkemy.disney.dto.CharacterWithoutMoviesDTO;
import com.alkemy.disney.dto.DeletedDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.service.ICharacterService;
import java.util.Set;
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
    public ResponseEntity<Set<CharacterSimpleDTO>> getAllCharacters(){
        Set<CharacterSimpleDTO> characterList = characterService.getAllCharacters();  
        return new ResponseEntity<>(characterList, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CharacterDetailsDTO> getCharacterById(@PathVariable Long id){
        CharacterDetailsDTO character = characterService.getCharacterById(id);   
        return ResponseEntity.ok().body(character);
    }
    
    @PostMapping
    public ResponseEntity<CharacterDetailsDTO> postCharacter(@Valid @RequestBody CharacterDetailsDTO newCharacter) {
        CharacterDetailsDTO characterSaved = characterService.saveCharacter(newCharacter);
        return ResponseEntity.status(HttpStatus.CREATED).body(characterSaved);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CharacterDetailsDTO> updateCharacter(@PathVariable Long id, @Valid @RequestBody CharacterWithoutMoviesDTO characterWithChanges){
        CharacterDetailsDTO characterUpdated = characterService.totalUpdateCharacter(id, characterWithChanges); 
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(characterUpdated);  
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<DeletedDTO> deleteCharacter(@PathVariable Long id){
        characterService.deleteCharacter(id);
        return ResponseEntity.status(HttpStatus.OK).body(new DeletedDTO(CharacterEntity.class));
    }
    
    // TODO: @PatchMapping
    
}
