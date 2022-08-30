package com.todo.springtodo.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
}
