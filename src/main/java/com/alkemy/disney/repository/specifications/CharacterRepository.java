package com.alkemy.disney.repository.specifications;

import com.alkemy.disney.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long>{
    
    // Query para borrado físico
    @Query(nativeQuery = true, value = "DELETE FROM disney.movies_characters WHERE character_id = :id")
    @Modifying
    public void removeParticipationsCharacter(@Param("id") Long id);
    
}
