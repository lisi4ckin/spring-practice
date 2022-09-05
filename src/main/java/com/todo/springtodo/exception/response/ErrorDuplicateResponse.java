package com.todo.springtodo.exception.response;

import com.todo.springtodo.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDuplicateResponse {
    private int statusCode;
    private String message;
    private UserDTO user;

    public ErrorDuplicateResponse(String message, UserDTO user){
        super();
        this.message = message;
        this.user = user;
    }
}
