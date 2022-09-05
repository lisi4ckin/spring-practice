package com.todo.springtodo.exception.exception_classes;


import com.todo.springtodo.dto.UserDTO;
import org.apache.catalina.User;


public class NoSuchUserException extends RuntimeException {
    private String message;

    private UserDTO user;

    public NoSuchUserException(String message, UserDTO user){
        super(message);
        this.message = message;
        this.user = user;
    }

    public NoSuchUserException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
