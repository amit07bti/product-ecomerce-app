package com.jafer.product.reop;

import com.jafer.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
}
