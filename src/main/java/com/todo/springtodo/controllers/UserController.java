package com.todo.springtodo.controllers;

import com.todo.springtodo.entities.Users;
import com.todo.springtodo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public HttpStatus addUser(@RequestBody Users users){
        userService.addUser(users);
        return HttpStatus.OK;
    }
}
