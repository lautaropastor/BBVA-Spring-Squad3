package com.alkemy.disney.auth.Mapper;

import com.alkemy.disney.auth.dto.MyUserDTO;
import com.alkemy.disney.auth.entity.MyUsersEntity;

public class UsersMapper {

    public MyUsersEntity toEntity (MyUserDTO myUserDTO) {
        MyUsersEntity myUsersEntity = new MyUsersEntity();
        myUsersEntity.setUsername(myUserDTO.getUsername());
        myUsersEntity.setPassword(myUserDTO.getPassword());

        return myUsersEntity;
    }

    public MyUserDTO toDto(MyUsersEntity myUsersEntity) {
        MyUserDTO myUserDTO = new MyUserDTO();
        myUserDTO.setUsername(myUsersEntity.getUsername());
        myUserDTO.setPassword(myUsersEntity.getPassword());

        return myUserDTO;
    }
}
