package com.todo.springtodo.services.impl;

import com.todo.springtodo.entities.Users;
import com.todo.springtodo.repositories.UserRepository;
import com.todo.springtodo.services.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public void addUser(Users users) {
        users.setHashPassword(users.getHashPassword());
        userRepository.save(users);
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public void updateBuyer(Users buyer) {

    }

    @Override
    public Users getById(Long id) {
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        return null;
    }
}
