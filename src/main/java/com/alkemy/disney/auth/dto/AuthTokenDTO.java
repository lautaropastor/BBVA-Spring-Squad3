package com.alkemy.disney.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthTokenDTO {
    private final String jwt;

}
