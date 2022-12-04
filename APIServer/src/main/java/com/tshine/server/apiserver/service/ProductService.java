package com.tshine.server.apiserver.service;

import com.tshine.server.apiserver.entities.product.Category;
import com.tshine.server.apiserver.entities.product.Product;
import com.tshine.server.apiserver.entities.store.Discount;
import com.tshine.server.common.dto.product.ProductRequest;
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
