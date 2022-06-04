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

@RestController
@RequestMapping()
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtils jwtTokenUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAutehnticationToken (@RequestBody MyUsersEntity myUsersEntity) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(myUsersEntity.getUsername(), myUsersEntity.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password ", e);
        }
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(myUsersEntity.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthTokenDTO(jwt));
    }

    @PostMapping("/authenticate/register")
    public ResponseEntity<?> register (@RequestBody MyUserDTO myUserDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(myUserDetailsService.register(myUserDTO));
    }
}
