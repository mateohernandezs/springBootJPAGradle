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

import com.bancodebogota.fdm.ejemplogradle.dto.UserDto;
import java.util.List;

public interface UserService {
    public UserDto addUser(UserDto user);
    public void deleteUser(UserDto user);
    public List<UserDto> getUsers();
    public UserDto getUserByLogin(String login);
    
}

