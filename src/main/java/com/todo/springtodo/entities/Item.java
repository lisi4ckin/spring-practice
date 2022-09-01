package com.todo.springtodo.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
public class Item {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float itemPrice;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull
    private Category category;

    @ManyToMany(mappedBy = "items")
    private Set<Order> orders;

}
