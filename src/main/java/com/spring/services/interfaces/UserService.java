package com.spring.services.interfaces;

import com.spring.entities.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);

    public List<User> getAllUsers();

    public User findById(int id);

    public User update(User user,int id);

    void deleteByID(int id);

    public User findByUsername(String username);
}
