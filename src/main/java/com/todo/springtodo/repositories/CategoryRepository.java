package com.todo.springtodo.repositories;

import com.todo.springtodo.entities.Category;
import com.todo.springtodo.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select items from Item items where items.category.categoryId=:id")
    List<Item> itemsInThisCategory(@Param("id") Long id);

    @Query("select category from Category category where category.title=:title")
    Category getCategoryByTitle(@Param("title") String title);
}
