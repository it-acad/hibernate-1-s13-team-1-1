package com.softserve.itacademy.service;

import com.softserve.itacademy.model.Role;
import com.softserve.itacademy.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User getByName(String name);
    User editUser(User user);
    User createOrUpdateUser(User user);
    List<User> getAll();
    User getUserById(long id);
    List<User> getAllByRole(Role role);
}
