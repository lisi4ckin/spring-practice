package com.todo.springtodo.dto;

import com.todo.springtodo.entities.Category;
import com.todo.springtodo.entities.Order;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class ItemsDTO {

    private Long id;
    private Float price;
    private String title;
    private String description;
    private CategoryDTO category;
}
