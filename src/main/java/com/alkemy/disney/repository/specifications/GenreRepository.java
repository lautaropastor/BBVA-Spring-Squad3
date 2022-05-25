package com.alkemy.disney.repository.specifications;

import com.alkemy.disney.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
}
