package com.todo.springtodo.services.impl;

import com.todo.springtodo.dto.ProfileDTO;
import com.todo.springtodo.entities.Profile;
import com.todo.springtodo.entities.Users;
import com.todo.springtodo.mappers.ProfileMapper;
import com.todo.springtodo.repositories.ProfileRepository;
import com.todo.springtodo.repositories.UserRepository;
import com.todo.springtodo.services.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class ProfileServiceImpl implements ProfileService {

    private static final Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);
    @Resource
    private UserRepository userRepository;

    @Resource
    private ProfileRepository profileRepository;

    @Resource
    private ProfileMapper profileMapper;
    @Override
    @Transactional
    public void addProfile(Profile profile) {
        Users userWithThisProfileId = userRepository.userByProfileId(profile.getId());
        if (userWithThisProfileId != null){
            logger.error("User with this profile exist", profile);
        }
        else{
            logger.error("User with this profile don't exist");
        }
    }

    @Override
    public void deleteProfile(Long id) {

    }

    @Override
    @Transactional
    public void updateProfile(ProfileDTO profileDTO) {
        Profile profile = profileMapper.toProfile(profileDTO);
        profileRepository.findById(profile.getId()).get().setFirstName(profile.getFirstName());
        profileRepository.findById(profile.getId()).get().setLastName(profile.getLastName());
        profileRepository.findById(profile.getId()).get().setAge(profile.getAge());
        profileRepository.findById(profile.getId()).get().setPhone(profile.getPhone());
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
