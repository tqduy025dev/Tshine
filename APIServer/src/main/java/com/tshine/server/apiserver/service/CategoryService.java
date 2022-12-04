package com.tshine.server.apiserver.service;

import com.tshine.server.apiserver.entities.product.Category;
import com.tshine.server.apiserver.entities.product.Product;
import com.tshine.server.common.dto.product.CategoryRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> findCategoryByIds(List<String> ids);
    Category createCategory(CategoryRequest categoryRequest);
    Category findCategoryById(String id);
    Page<Category> findAllCategory(Pageable pageable);
}
