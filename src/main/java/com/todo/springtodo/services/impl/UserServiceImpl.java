package com.todo.springtodo.services.impl;

import com.todo.springtodo.dto.ProfileDTO;
import com.todo.springtodo.dto.UserDTO;
import com.todo.springtodo.entities.Profile;
import com.todo.springtodo.entities.Users;
import com.todo.springtodo.mappers.ProfileMapper;
import com.todo.springtodo.mappers.UserMapper;
import com.todo.springtodo.repositories.UserRepository;
import com.todo.springtodo.services.ProfileService;
import com.todo.springtodo.services.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ProfileMapper profileMapper;

    @Resource
    private UserRepository userRepository;

    @Resource
    private ProfileService profileService;

    @Override
    @Transactional
    public void addUser(Users users) {
        users.setHashPassword(users.getHashPassword());
        userRepository.save(users);
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    @Transactional
    public void updateUser(UserDTO userDTO) {
        Users user = userMapper.toUsers(userDTO);
        userRepository.findById(user.getId()).get().setLogin(user.getLogin());
        userRepository.findById(user.getId()).get().setHashPassword(user.getHashPassword());
        profileService.updateProfile(profileMapper.toProfileDTO(user.getProfile()));
        userRepository.findById(user.getId()).get().setOrderList(user.getOrderList());
    }

    @Override
    public UserDTO getById(Long id) {
        return userMapper.toUserDTO(userRepository.findById(id).get());
    }

    @Override
    public Set<UserDTO> getAllUsers() {
        return userMapper.toUserDTOs(new HashSet<Users>(userRepository.findAll()));
    }
}
