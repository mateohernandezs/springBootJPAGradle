/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancodebogota.fdm.ejemplogradle.service;

/**
 *
 * @author admin
 */

import com.bancodebogota.fdm.ejemplogradle.dao.UserRepository;
import com.bancodebogota.fdm.ejemplogradle.dto.UserDto;
import com.bancodebogota.fdm.ejemplogradle.entities.UserEntity;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl (UserRepository userRepository){
        
        this.userRepository = userRepository;
    }
    

    @Override
    public UserDto addUser(UserDto user) {
        return this.getDTO(userRepository.save(this.getEntity(user)));
    }

    @Override
    public void deleteUser(UserDto user) {
        userRepository.delete(getEntity(user));
    }

    @Override
    public List<UserDto> getUsers() {
        ArrayList<UserDto> users = new ArrayList();
        userRepository.findAll().forEach((ue) -> {
            users.add(getDTO(ue));
        });
        return users;       
    }

    @Override
    public UserDto getUserByLogin(String login) {
        return this.getDTO(userRepository.findByLogin(login));
    }
    
    
    private UserDto getDTO(UserEntity user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDto dto = modelMapper.map(user, UserDto.class);
        return dto;
    }
    
    private UserEntity getEntity(UserDto user) {
        ModelMapper modelMapper = new ModelMapper();
        UserEntity entity = modelMapper.map(user, UserEntity.class);
        return entity;
    }    
    
}

