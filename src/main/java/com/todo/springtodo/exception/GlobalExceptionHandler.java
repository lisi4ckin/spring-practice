package com.todo.springtodo.exception;

import com.todo.springtodo.exception.exception_classes.DuplicateLoginUserAdd;
import com.todo.springtodo.exception.exception_classes.NoSuchUserException;
import com.todo.springtodo.exception.response.ErrorDuplicateResponse;
import com.todo.springtodo.exception.response.ErrorUserResponse;
import com.todo.springtodo.mappers.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @Resource
    private UserMapper userMapper;

    @ExceptionHandler(value = DuplicateLoginUserAdd.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ErrorDuplicateResponse
    handleDuplicateException(DuplicateLoginUserAdd ex){
        return new ErrorDuplicateResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                userMapper.toUserDTO(ex.getUser())
        );
    }
}
