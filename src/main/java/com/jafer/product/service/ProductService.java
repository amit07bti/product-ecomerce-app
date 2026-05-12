package com.jafer.product.service;

import com.jafer.product.dto.ProductDTO;
import com.jafer.product.exception.CategoryNotFoundException;
import com.jafer.product.mapper.ProductMapper;
import com.jafer.product.model.Category;
import com.jafer.product.model.Product;
import com.jafer.product.reop.CategoryRepo;
import com.jafer.product.reop.ProductRepo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    public ProductDTO createProduct(ProductDTO productDTO) {
        //id,name,description,price,categoryId
        Category category = categoryRepo.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category id:  "+productDTO.getCategoryId()+" found! "));
        //DTO to entity
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepo.save(product);
        //entity to DTO
        return ProductMapper.toProductDTO(product);

    }

    //get all products
    public List<ProductDTO> getAllProducts() {
        return productRepo.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }
    //get product by id

    public ProductDTO getProductById(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found!"));
        return ProductMapper.toProductDTO(product);
    }

    //update product
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found!"));
        Category category = categoryRepo.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found! "));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        product = productRepo.save(product);
        return ProductMapper.toProductDTO(product);
    }

    //delete product
    public String deleteProduct(Long id) {
        if(!productRepo.existsById(id)){
            throw new RuntimeException("Product not found!");
        }
        productRepo.deleteById(id);
        return "Product deleted successfully!";


    }
}