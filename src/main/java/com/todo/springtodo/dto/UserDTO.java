package com.todo.springtodo.dto;

import com.sun.istack.NotNull;
import com.todo.springtodo.entities.Order;
import com.todo.springtodo.entities.Profile;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class UserDTO {

    private String login;
    private String password;
    private Profile profile;
    private List<Order> order_list;
}
