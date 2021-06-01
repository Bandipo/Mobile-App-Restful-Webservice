package com.example.mobileappwebservice.controllers;

import com.example.mobileappwebservice.service.UserService;
import com.example.mobileappwebservice.service.impl.UserServiceImpl;
import com.example.mobileappwebservice.shared.dto.UserDto;
import com.example.mobileappwebservice.ui.model.request.UserDetailsRequestModel;
import com.example.mobileappwebservice.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")

public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public  ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userDetails){

        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails,userDto);// copies the userDetails request into the Userdto

        UserDto createdUser = userService.createUser(userDto);

        BeanUtils.copyProperties(createdUser,returnValue);


        return new ResponseEntity<UserRest>( HttpStatus.OK);
    }

    @GetMapping
    public String getUser(){
        return "CreateUser was called";
    }

    @PutMapping
    public String updateUser(){
        return "update user called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}
