package com.todo.springtodo.exception.response;

import com.todo.springtodo.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorUserResponse {
    private int statusCode;
    private String message;
    private UserDTO object;

    public ErrorUserResponse(String message, UserDTO object){
        super();
        this.message = message;
        this.object = object;
    }
}
