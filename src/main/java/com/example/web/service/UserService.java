package com.example.web.service;

import com.example.web.dto.RegistrationDto;
import com.example.web.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
