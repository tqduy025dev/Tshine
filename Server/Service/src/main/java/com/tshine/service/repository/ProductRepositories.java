package com.tshine.service.repository;

import com.tshine.common.entities.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositories extends JpaRepository<Product, String> {
    Page<Product> findProductByCategoriesCategoryId(String catygoryId, Pageable pageable);
}
