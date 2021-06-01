package com.example.mobileappwebservice.shared.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter@Setter
public class UserDto implements Serializable {
    @Setter(AccessLevel.NONE)@Getter(AccessLevel.NONE)
    private static final long serialVersionUID = -5577568395676129923L;

    private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encryptedPassword;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus =false;
}
