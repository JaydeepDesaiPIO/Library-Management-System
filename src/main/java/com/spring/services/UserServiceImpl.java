package com.spring.services;

import com.spring.entities.User;
import com.spring.repositories.UserRepository;
import com.spring.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User addUser(User user) {
        user.setRole("ROLE_ADMIN");
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User update(User user,int id) {
        // get book from database by id
        User existingUser =userRepository.findById(id).get();
        existingUser.setUsername(user.getUsername());
        existingUser.setContact(user.getContact());
        existingUser.setAddress(user.getAddress());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteByID(int id) {
         userRepository.deleteById(id);
    }
}
