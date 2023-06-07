package com.spring.services;

import com.spring.entities.User;
import com.spring.repositories.UserRepository;
import com.spring.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
