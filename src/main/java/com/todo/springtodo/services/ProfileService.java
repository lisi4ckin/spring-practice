package com.todo.springtodo.services;

import com.todo.springtodo.dto.ProfileDTO;
import com.todo.springtodo.dto.UserDTO;
import com.todo.springtodo.entities.Profile;
import com.todo.springtodo.entities.Users;

import java.util.Set;

public interface ProfileService {
    void addProfile(Profile profile);
    void deleteProfile(Long id);
    void updateProfile(ProfileDTO profileDTO);
    ProfileDTO getById(Long id);
    Set<ProfileDTO> getAllProfiles();
}
