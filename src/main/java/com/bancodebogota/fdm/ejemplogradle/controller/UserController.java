/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancodebogota.fdm.ejemplogradle.controller;

/**
 *
 * @author admin
 */

import com.bancodebogota.fdm.ejemplogradle.dto.UserDto;
import com.bancodebogota.fdm.ejemplogradle.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

    final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping(value="/create", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UserDto create(@RequestBody UserDto user) {
        return userService.addUser(user);
    }
    
    @RequestMapping(value="/getUsers", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.FOUND)    
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }
    
    //@RequestMapping(value="/getUsersByLogin", method = RequestMethod.GET, produces = "application/json")
    //@ResponseStatus(HttpStatus.FOUND)    
    //@ResponseBody
    //public UserDto getUserByLogin(@RequestBody UserDto user) {
    //    return userService.getUserByLogin(user.getLogin());
    //}
    
    
    @RequestMapping(value="/deleteUser", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void deleteUser(@RequestBody UserDto user) {
        userService.deleteUser(user);
    }

}

