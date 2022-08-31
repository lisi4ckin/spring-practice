package com.todo.springtodo.services;

import com.todo.springtodo.dto.UserDTO;
import com.todo.springtodo.entities.Users;

import java.util.Set;

public interface UserService {
    void addUser(Users users);
    void deleteUser(Long id);
    void updateUser(UserDTO userDTO);
    UserDTO getById(Long id);
    Set<UserDTO> getAllUsers();
}
