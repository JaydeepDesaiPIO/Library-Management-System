package com.spring.services.interfaces;

import com.spring.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public void addUser(User user);

    public List<User> getAllUsers();

    public User findById(int id);

    public User update(User user);

    void deletebyID(int id);
}
