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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private Users user;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "order_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private Set<Item> items;

    /*
    * Методы синхронизации ссылок для bidirectional отношений
    * */

    public void addItem(Item item){
        this.items.add(item);
        item.getOrders().add(this);
    }

    public void removeItem(Item item){
        this.items.remove(item);
        item.getOrders().remove(this);
    }
}
