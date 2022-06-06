package com.alkemy.disney.auth.controller;
import com.alkemy.disney.auth.dto.AuthTokenDTO;
import com.alkemy.disney.auth.dto.MyUserDTO;
import com.alkemy.disney.auth.entity.MyUsersEntity;
import com.alkemy.disney.auth.service.MyUserDetailsService;
import com.alkemy.disney.auth.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping()
public class AuthenticateController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @PostMapping("/authenticate/login")
    public ResponseEntity<?> createAutehnticationToken (@Valid @RequestBody MyUserDTO myUserDTO) throws Exception {
        String jwt = myUserDetailsService.getJwt(myUserDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new AuthTokenDTO(jwt));
    }

    @PostMapping("/authenticate/register")
    public ResponseEntity<?> register (@Valid @RequestBody MyUserDTO myUserDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(myUserDetailsService.register(myUserDTO));
    }
}
