package com.todo.springtodo.services.impl;

import com.todo.springtodo.dto.CategoryDTO;
import com.todo.springtodo.entities.Category;
import com.todo.springtodo.entities.Item;
import com.todo.springtodo.repositories.CategoryRepository;
import com.todo.springtodo.services.CategoryService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    @Override
    public void addCategory(Category category) {

    }

    @Override
    public void deleteCategory(Long id) {

    }

    @Override
    public void updateCategory(CategoryDTO CategoryDTO) {

    }

    @Override
    public CategoryDTO getById(Long id) {
        return null;
    }

    @Override
    public Set<CategoryDTO> getAllProfiles() {
        return null;
    }

    @Override
    public List<Item> getItemInThisCategory(Long id) {
        return categoryRepository.itemsInThisCategory(id);
    }
}
