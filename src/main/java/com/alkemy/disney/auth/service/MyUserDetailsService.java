package com.alkemy.disney.auth.service;

import com.alkemy.disney.auth.Mapper.UsersMapper;
import com.alkemy.disney.auth.dto.AuthTokenDTO;
import com.alkemy.disney.auth.dto.MyUserDTO;
import com.alkemy.disney.auth.entity.MyUsersEntity;
import com.alkemy.disney.auth.repository.UserRepository;
import com.alkemy.disney.auth.utils.JwtUtils;
import com.alkemy.disney.exception.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;


    public MyUserDTO register(MyUserDTO myUserDTO) {
        MyUsersEntity myUsersEntity = usersMapper.toEntity(myUserDTO);
        myUsersEntity.setPassword(encryptPassword(myUsersEntity.getPassword()));
        MyUsersEntity myUsersEntitySaved = userRepository.save(myUsersEntity);
        return usersMapper.toDtoWithouPass(myUsersEntitySaved);
    }

    private String encryptPassword (String password) {
        //llamamos a passwordEncoder para encriptar la pass.
        return passwordEncoder.encode(password);
    }

    public String getJwt(MyUserDTO myUserDTO) throws Exception {
        MyUsersEntity myUsersEntity = usersMapper.toEntity(myUserDTO);
        Authentication auth;
        try {
            auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(myUsersEntity.getUsername(), myUsersEntity.getPassword())
            );
        } catch (BadCredentialsException | InternalAuthenticationServiceException e ) {
            throw new Exception(Error.INVALID_USERDATA.getMessage(), e);
        }
        final String jwt = jwtTokenUtil.generateToken((UserDetails) auth.getPrincipal());
        return jwt;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUsersEntity myUsersEntity = userRepository.findByUsername(username);
        return new User(myUsersEntity.getUsername(), myUsersEntity.getPassword(), new ArrayList<>());
    }
}
