package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.User;

public interface UserService {
    List < User > getAllUsers();
    void saveUser(User user);
    User getUserById(long id);
    void deleteUserById(long id);
}