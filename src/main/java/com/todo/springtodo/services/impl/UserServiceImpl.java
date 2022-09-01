package com.todo.springtodo.services.impl;

import com.todo.springtodo.controllers.UserController;
import com.todo.springtodo.dto.ProfileDTO;
import com.todo.springtodo.dto.UserDTO;
import com.todo.springtodo.entities.Profile;
import com.todo.springtodo.entities.Users;
import com.todo.springtodo.mappers.ProfileMapper;
import com.todo.springtodo.mappers.UserMapper;
import com.todo.springtodo.repositories.UserRepository;
import com.todo.springtodo.services.ProfileService;
import com.todo.springtodo.services.UserService;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUser(UserDTO userDTO) {
        Users dataUpdateUser = userMapper.toUsers(userDTO);
        Optional<Users> user = userRepository.findById(dataUpdateUser.getId());
        if (user.isPresent()){

            logger.debug("Start update user with id={}", dataUpdateUser.getId());

            Users updateUser = user.get();
            updateUser.setLogin(dataUpdateUser.getLogin());
            updateUser.setHashPassword(dataUpdateUser.getHashPassword());
            profileService.updateProfile(profileMapper.toProfileDTO(dataUpdateUser.getProfile()));
            updateUser.setOrderList(dataUpdateUser.getOrderList());
            userRepository.save(updateUser);

            logger.debug("Finished update user with id={}", dataUpdateUser.getId());
        }
        else{
            logger.error("User with this id={} don't exist", dataUpdateUser.getId());
        }
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
