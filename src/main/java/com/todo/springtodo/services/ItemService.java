package com.todo.springtodo.services;

import com.todo.springtodo.dto.ItemsDTO;
import com.todo.springtodo.dto.ProfileDTO;
import com.todo.springtodo.entities.Item;
import com.todo.springtodo.entities.Profile;

import java.util.Set;

public interface ItemService {
    void addItem(Item items);
    void deleteItem(Long id);
    void updateItem(ItemsDTO itemDTO);
    ItemsDTO getById(Long id);
    Set<ItemsDTO> getAllItems();

    Long getId(ItemsDTO itemsDTO);
}
