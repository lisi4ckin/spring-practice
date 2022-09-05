package com.todo.springtodo.exception;

import com.todo.springtodo.exception.exception_classes.NoSuchUserException;
import com.todo.springtodo.exception.response.ErrorUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NoSuchUserException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ErrorUserResponse
    handleException(NoSuchUserException ex){
        return new ErrorUserResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                ex.getUser()
        );
    }
}
