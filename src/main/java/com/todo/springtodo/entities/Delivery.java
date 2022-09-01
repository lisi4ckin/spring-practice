package com.todo.springtodo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Delivery {

    @Id
    @Column(name = "order_id")
    private Long id;

    private Date deliveryDate;
    private String deliveryType;
    private Float deliveryCost;
    private Integer countItems;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "order_id")
    private Order order;
}
