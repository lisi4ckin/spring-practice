package com.todo.springtodo.dto;

import com.sun.istack.NotNull;
import com.todo.springtodo.entities.Order;
import com.todo.springtodo.entities.Profile;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class UserDTO {

    private Long id;
    private String login;
    private String password;
    private ProfileDTO profile;
    private List<OrderDTO> order_list;
}
