package com.todo.springtodo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer state;
    private Float orderCost;
    private String paymentMethod;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "order_item",
            joinColumns ={ @JoinColumn(name = "items_id") },
            inverseJoinColumns ={ @JoinColumn(name = "orders_id") }
    )
    private Set<Item> items;

}
