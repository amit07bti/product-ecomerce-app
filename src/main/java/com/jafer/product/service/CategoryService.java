package com.jafer.product.service;

import com.jafer.product.dto.CategoryDTO;
import com.jafer.product.mapper.CategoryMapper;
import com.jafer.product.model.Category;
import com.jafer.product.reop.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    //get category by id
    //delete category
}
