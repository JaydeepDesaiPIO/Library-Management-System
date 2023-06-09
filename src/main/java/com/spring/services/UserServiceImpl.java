package com.spring.services;

import com.spring.dto.UserRegisterationDto;
import com.spring.entities.Role;
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
    public User addUser(UserRegisterationDto userRegisterationDto) {
        User user=new User(userRegisterationDto.getUsername()
                ,userRegisterationDto.getEmail()
                ,userRegisterationDto.getPassword()
                ,userRegisterationDto.getContact()
                ,userRegisterationDto.getAddress(), Arrays.asList(new Role("ROLE_ADMIN")));

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
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deletebyID(int id) {
         userRepository.deleteById(id);
    }
}
