package com.tshine.server.apiserver.repository;

import com.tshine.server.apiserver.entities.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositories extends JpaRepository<Product, String> {
    Page<Product> findProductByCategoriesCategoryId(String catygoryId, Pageable pageable);
}
