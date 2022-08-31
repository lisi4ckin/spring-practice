package com.todo.springtodo.mappers;

import com.todo.springtodo.dto.UserDTO;
import com.todo.springtodo.entities.Users;
import org.apache.catalina.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class})
public interface UserMapper {
    @Mappings({
        @Mapping(source = "hashPassword", target = "password"),
        @Mapping(source = "orderList", target = "order_list")
    })
    UserDTO toUserDTO(Users user);

    Set<UserDTO> toUserDTOs(Set<Users> users);

    @Mappings({
            @Mapping(target = "hashPassword", source = "password"),
            @Mapping(target = "orderList", source = "order_list")
    })
    Users toUsers(UserDTO userDTO);
}
