package com.spring.services;

import com.spring.entities.Book;
import com.spring.entities.User;
import com.spring.repositories.UserRepository;
import com.spring.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User addUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
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
        User user=userRepository.findById(id).get();
        List<Book> bookList=user.getBooks();
        for (Book b : bookList)
        {
            if(b.isAvailable()==false)
                b.setAvailable(true);
        }
         userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.getUserByName(username);
    }
}
