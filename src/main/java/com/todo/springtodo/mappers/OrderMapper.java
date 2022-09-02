package com.todo.springtodo.mappers;

import com.todo.springtodo.dto.ItemsDTO;
import com.todo.springtodo.dto.OrderDTO;
import com.todo.springtodo.entities.Item;
import com.todo.springtodo.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {ItemsMapper.class})
public interface OrderMapper {
    //    private Float cost;
//    private String payment_method;
    @Mapping(source = "orderCost", target = "cost")
    @Mapping(source = "paymentMethod", target = "payment_method")
    OrderDTO toOrderDTO(Order order);

    Set<OrderDTO> toOrderDTOs(Set<Order> orders);

    @Mapping(source = "cost", target = "orderCost")
    @Mapping(source = "payment_method", target = "paymentMethod")
    Order toItem(OrderDTO orderDTO);
}
