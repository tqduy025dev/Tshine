package com.tshine.service.service;

import com.tshine.common.dto.product.ProductRequest;
import com.tshine.common.entities.product.Category;
import com.tshine.common.entities.product.Product;
import com.tshine.common.entities.store.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest productRequest, List<Category> categories, Discount discount) throws IOException;
    Product findProductById(String id);
    Page<Product> findProductByCategory(String catygoryId, Pageable pageable);
    Page<Product> findAllProduct(Pageable pageable);
}
