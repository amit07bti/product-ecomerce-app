package com.jafer.product.controller;

import com.jafer.product.dto.CategoryDTO;
import com.jafer.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //get all categories
    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();

    }
    //create category
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return  new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);

    }
    //get category by id
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }
    //delete category
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        return categoryService.deleteCategory(id);
    }
}
