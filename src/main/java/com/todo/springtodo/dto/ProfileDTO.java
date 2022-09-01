package com.todo.springtodo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProfileDTO {
    private Long id;
    private String first_name;
    private String last_name;
    private String phone;
    private Integer age;
    private Date registry = new Date();
}
