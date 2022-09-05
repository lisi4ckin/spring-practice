package com.todo.springtodo.services.impl;

import com.todo.springtodo.dto.UserDTO;
import com.todo.springtodo.entities.Users;
import com.todo.springtodo.exception.exception_classes.DuplicateLoginUserAdd;
import com.todo.springtodo.exception.exception_classes.NoSuchUserException;
import com.todo.springtodo.mappers.ProfileMapper;
import com.todo.springtodo.mappers.UserMapper;
import com.todo.springtodo.repositories.UserRepository;
import com.todo.springtodo.services.ProfileService;
import com.todo.springtodo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
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
        Users existingUser = userRepository.userByLogin(users.getLogin());
        if (existingUser == null) {
            userRepository.save(users);
        }
        else {
            throw new DuplicateLoginUserAdd(String.format("User with this login=%s don't exist", users.getLogin()), users);
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUser(UserDTO userDTO) {
        Users existingUser = userRepository.findById(userDTO.getId()).orElse(null);
        if (existingUser != null){
            logger.debug("Start update user with id={}", userDTO.getId());
            existingUser.setLogin(userDTO.getLogin());
            existingUser.setHashPassword(userDTO.getPassword());
            profileService.updateProfile(profileMapper.toProfileDTO(profileMapper.toProfile(userDTO.getProfile())));
            logger.debug("Finished update user with id={}", existingUser.getId());
        }
        else{
            throw new NoSuchUserException(String.format("User with this id=%d don't exist", userDTO.getId()), userDTO);
        }
    }

    @Override
    public UserDTO getById(Long id) {
        Users existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null){
            throw new NoSuchUserException("No such user with this id=" + id);
        }
        return userMapper.toUserDTO(existingUser);
    }

    @Override
    public Set<UserDTO> getAllUsers() {
        return userMapper.toUserDTOs(new HashSet<Users>(userRepository.findAll()));
    }
}
