package com.example.validate_register.service.impl;

import com.example.validate_register.model.User;
import com.example.validate_register.repository.IUserRepository;
import com.example.validate_register.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;
    @Override
    public void submit(User user) {
        userRepository.save(user);
    }
}
