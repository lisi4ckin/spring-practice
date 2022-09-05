package com.todo.springtodo.exception.exception_classes;

import com.todo.springtodo.entities.Users;

public class DuplicateLoginUserAdd extends RuntimeException{
    private String message;
    private Users user;

    public DuplicateLoginUserAdd(String message, Users user){
        super(message);
        this.message = message;
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
