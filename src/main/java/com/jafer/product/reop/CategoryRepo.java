package com.jafer.product.reop;

import com.jafer.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
    //find category by name
    Optional<Category> findByName(String categoryName);
}
