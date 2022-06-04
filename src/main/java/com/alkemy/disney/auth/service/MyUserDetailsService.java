package com.alkemy.disney.auth.service;

import com.alkemy.disney.auth.Mapper.UsersMapper;
import com.alkemy.disney.auth.dto.AuthTokenDTO;
import com.alkemy.disney.auth.dto.MyUserDTO;
import com.alkemy.disney.auth.entity.MyUsersEntity;
import com.alkemy.disney.auth.repository.UserRepository;
import com.alkemy.disney.auth.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService { //UDS es una clase de SpringSecurity
    @Autowired
    UserRepository userRepository;

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtTokenUtil;


    public MyUserDTO register(MyUserDTO myUserDTO) {
        MyUsersEntity myUsersEntity = usersMapper.toEntity(myUserDTO);
        MyUsersEntity myUsersEntitySaved = userRepository.save(myUsersEntity);
        return usersMapper.toDto(myUsersEntitySaved);
    }

    public String getJwt(MyUserDTO myUserDTO) throws Exception {
        MyUsersEntity myUsersEntity = usersMapper.toEntity(myUserDTO);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(myUsersEntity.getUsername(), myUsersEntity.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password ", e);
        }
        final UserDetails userDetails = loadUserByUsername(myUsersEntity.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return jwt;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUsersEntity myUsersEntity = userRepository.findByUsername(username);
        return new User(myUsersEntity.getUsername(), myUsersEntity.getPassword(), new ArrayList<>());
    }
}
