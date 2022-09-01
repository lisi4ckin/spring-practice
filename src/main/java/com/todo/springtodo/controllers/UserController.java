package com.todo.springtodo.controllers;

import com.todo.springtodo.dto.UserDTO;
import com.todo.springtodo.entities.Users;
import com.todo.springtodo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.awt.image.RescaleOp;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public HttpStatus addUser(@RequestBody Users users){
        logger.debug("operation=addUser, action=start");
        userService.addUser(users);
        logger.debug("operation=addUser, action=end");
        return HttpStatus.OK;
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?>updateUser(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return HttpStatus.OK;
    }

}
