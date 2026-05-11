package com.jafer.product.service;

import com.jafer.product.dto.CategoryDTO;
import com.jafer.product.mapper.CategoryMapper;
import com.jafer.product.model.Category;
import com.jafer.product.reop.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    //create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category=CategoryMapper.toCategoryEntity(categoryDTO);
         category= categoryRepo.save(category);
        return CategoryMapper.toCategoryDTO(category);

    }
    //get all categories
    public List<CategoryDTO> getAllCategories() {
        return categoryRepo.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }
    //get category by id
    public CategoryDTO getCategoryById(Long id) {
        Category category=categoryRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Category not found!"));
        return CategoryMapper.toCategoryDTO(category);
    }
    //delete category
    public String deleteCategory(Long id) {
        categoryRepo.deleteById(id);
        return "Category deleted successfully!";
    }
}
