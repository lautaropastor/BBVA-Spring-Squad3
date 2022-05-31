package com.alkemy.disney.repository.specifications;

import com.alkemy.disney.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
}
