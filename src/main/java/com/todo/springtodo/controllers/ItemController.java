package com.todo.springtodo.controllers;

import com.todo.springtodo.dto.ItemsDTO;
import com.todo.springtodo.entities.Item;
import com.todo.springtodo.services.ItemService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody Item item){
        itemService.addItem(item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public Set<ItemsDTO> getAllItems(){
        return itemService.getAllItems();
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteItem(@PathVariable("id") Long id){
        itemService.deleteItem(id);
        return HttpStatus.OK;
    }

    @PutMapping
    public ItemsDTO updateItem(@RequestBody ItemsDTO itemsDTO){
        itemService.updateItem(itemsDTO);
        return itemService.getById(itemService.getId(itemsDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable("id") Long id){
        return new ResponseEntity<>(itemService.getById(id), HttpStatus.OK);
    }
}
