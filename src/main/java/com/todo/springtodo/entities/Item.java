package com.todo.springtodo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Item {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float itemPrice;
    private String title;
    private String description;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            }
    )
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "items")
    private Set<Order> orders;


}
