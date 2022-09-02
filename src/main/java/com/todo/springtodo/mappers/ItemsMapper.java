package com.todo.springtodo.mappers;

import com.todo.springtodo.dto.ItemsDTO;
import com.todo.springtodo.entities.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ItemsMapper {

    @Mapping(source = "itemPrice", target = "price")
    ItemsDTO toItemsDTO(Item item);

    Set<ItemsDTO> toItemsDTOs(Set<Item> items);

    @Mapping(source = "price", target = "itemPrice")
    Item toItem(ItemsDTO itemDTO);
}
