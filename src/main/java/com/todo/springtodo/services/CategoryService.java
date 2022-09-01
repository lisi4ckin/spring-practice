package com.todo.springtodo.services;


import com.todo.springtodo.dto.CategoryDTO;
import com.todo.springtodo.entities.Category;
import com.todo.springtodo.entities.Item;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    void addCategory(Category category);
    void deleteCategory(String title);
    void updateCategory(CategoryDTO CategoryDTO);
    CategoryDTO getById(Long id);
    Set<CategoryDTO> getAllCategories();
    List<Item> getItemInThisCategory(Long id);
}
