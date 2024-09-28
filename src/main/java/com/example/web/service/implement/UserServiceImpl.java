package com.example.web.service.implement;

import com.example.web.dto.RegistrationDto;
import com.example.web.models.Role;
import com.example.web.models.UserEntity;
import com.example.web.repository.RoleRepository;
import com.example.web.repository.UserRepository;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

//    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
}
