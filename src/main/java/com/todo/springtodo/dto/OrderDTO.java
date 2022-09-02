package com.todo.springtodo.dto;

import lombok.Data;

import java.util.Set;

@Data
public class OrderDTO {
    private Integer state;
    private Float cost;
    private String payment_method;
    private Set<ItemsDTO> items;
}
