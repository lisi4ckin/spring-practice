package com.todo.springtodo.services.impl;

import com.todo.springtodo.dto.ProfileDTO;
import com.todo.springtodo.entities.Profile;
import com.todo.springtodo.mappers.ProfileMapper;
import com.todo.springtodo.repositories.ProfileRepository;
import com.todo.springtodo.services.ProfileService;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

public class ProfileServiceImpl implements ProfileService {

    @Resource
    private ProfileRepository profileRepository;

    @Resource
    private ProfileMapper profileMapper;
    @Override
    public void addProfile(Profile profile) {

    }

    @Override
    public void deleteProfile(Long id) {

    }

    @Override
    public void updateProfile(Profile profile) {

    }

    @Override
    public ProfileDTO getById(Long id) {
        return profileMapper.toProfileDTO(profileRepository.findById(id).get());
    }

    @Override
    public Set<ProfileDTO> getAllProfiles() {
        return profileMapper.toProfileDTOs(new HashSet<Profile>(profileRepository.findAll()));
    }
}
