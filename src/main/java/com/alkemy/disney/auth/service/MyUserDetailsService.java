package com.alkemy.disney.auth.service;

import com.alkemy.disney.auth.Mapper.UsersMapper;
import com.alkemy.disney.auth.dto.MyUserDTO;
import com.alkemy.disney.auth.entity.MyUsersEntity;
import com.alkemy.disney.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public MyUserDTO register(MyUserDTO myUserDTO) {
        MyUsersEntity myUsersEntity = usersMapper.toEntity(myUserDTO);
        MyUsersEntity myUsersEntitySaved = userRepository.save(myUsersEntity);
        return usersMapper.toDto(myUsersEntitySaved);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUsersEntity myUsersEntity = userRepository.findByUsername(username);
        //MyUserDTO myUserDTO = usersMapper.toDto(myUsersEntity);
        return new User(myUsersEntity.getUsername(), myUsersEntity.getPassword(), new ArrayList<>());
    }
}
