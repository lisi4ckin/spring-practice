package com.todo.springtodo.repositories;

import com.todo.springtodo.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
