package com.todo.springtodo.mappers;

import com.todo.springtodo.dto.CategoryDTO;
import com.todo.springtodo.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toCategoryDTO(Category category);

    Set<CategoryDTO> toCategoryDTOs(Set<Category> categories);

    Category toCategory(CategoryDTO categoryDTO);
}
