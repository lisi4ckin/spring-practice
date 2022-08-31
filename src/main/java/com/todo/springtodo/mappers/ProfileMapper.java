package com.todo.springtodo.mappers;

import com.todo.springtodo.dto.ProfileDTO;
import com.todo.springtodo.entities.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    @Mappings({
            @Mapping(source = "firstName", target = "first_name"),
            @Mapping(source = "lastName", target = "last_name"),
            @Mapping(source = "registryDate", target = "registry"),
    })
    ProfileDTO toProfileDTO(Profile profile);

    Set<ProfileDTO> toProfileDTOs(Set<Profile> profiles);

    @Mappings({
            @Mapping(target = "firstName", source = "first_name"),
            @Mapping(target = "lastName", source = "last_name"),
            @Mapping(target = "registryDate", source = "registry"),
    })
    Profile toProfile(ProfileDTO profileDTO);
}
