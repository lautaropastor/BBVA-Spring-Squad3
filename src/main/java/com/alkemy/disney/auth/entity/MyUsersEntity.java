package com.alkemy.disney.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "users")
public class AuthEntity {
    private String username;
    private String password;
}
