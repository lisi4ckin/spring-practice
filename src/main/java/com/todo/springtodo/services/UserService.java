package com.todo.springtodo.services;

import com.todo.springtodo.entities.Users;

import java.util.List;

public interface UserService {
    void addUser(Users users);
    void deleteUser(Long id);
    void updateBuyer(Users buyer);
    Users getById(Long id);
    List<Users> getAllUsers();
}
