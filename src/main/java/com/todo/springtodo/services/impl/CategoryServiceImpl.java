package com.todo.springtodo.services.impl;

import com.todo.springtodo.dto.CategoryDTO;
import com.todo.springtodo.entities.Category;
import com.todo.springtodo.entities.Item;
import com.todo.springtodo.mappers.CategoryMapper;
import com.todo.springtodo.repositories.CategoryRepository;
import com.todo.springtodo.services.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    @Transactional
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategory(String title) {
        Category deletedCategory = categoryRepository.getCategoryByTitle(title);
        categoryRepository.deleteById(deletedCategory.getCategoryId());
    }

    @Override
    public void updateCategory(CategoryDTO CategoryDTO) {

    }

    @Override
    public CategoryDTO getById(Long id) {
        return categoryMapper.toCategoryDTO(categoryRepository.findById(id).get());
    }

    @Override
    public Set<CategoryDTO> getAllCategories() {
        return categoryMapper.toCategoryDTOs(
                new HashSet<Category>(categoryRepository.findAll())
        );
    }

    @Override
    public List<Item> getItemInThisCategory(Long id) {
        return categoryRepository.itemsInThisCategory(id);
    }
}
