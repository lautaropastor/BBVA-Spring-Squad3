package com.alkemy.disney.auth.repository;

import com.alkemy.disney.auth.entity.MyUsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MyUsersEntity, Long> {
    MyUsersEntity findByUsername(String username);
}
