package com.example.mobileappwebservice.service.impl;

import com.example.mobileappwebservice.entity.User;
import com.example.mobileappwebservice.repository.UserRepository;
import com.example.mobileappwebservice.service.UserService;
import com.example.mobileappwebservice.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User newUser = new User();

        BeanUtils.copyProperties(userDto,newUser);
        newUser.setEncryptedPassword("password");
        newUser.setUserId("Test UserId");
        User storeUserDetails = userRepository.save(newUser);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storeUserDetails,returnValue);

        return  returnValue;
    }
}
