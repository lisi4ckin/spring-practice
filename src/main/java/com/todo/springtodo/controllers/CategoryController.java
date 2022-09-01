package com.todo.springtodo.controllers;

import com.todo.springtodo.dto.CategoryDTO;
import com.todo.springtodo.entities.Category;
import com.todo.springtodo.services.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.Set;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public HttpStatus addCategory(Category category){
        logger.debug("operation=addCategory, action=start");
        categoryService.addCategory(category);
        logger.debug("operation=addCategory, action=end");
        return HttpStatus.OK;
    }

    @GetMapping("/get")
    public Set<CategoryDTO> getCategories(){
        return categoryService.getAllCategories();
    }
}
