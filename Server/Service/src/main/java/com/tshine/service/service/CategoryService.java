package com.tshine.service.service;

import com.tshine.common.dto.base.BaseData;
import com.tshine.common.dto.product.CategoryRequest;
import com.tshine.common.entities.product.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> findCategoryByIds(List<String> ids);
    Category findCategoryById(String id);
    BaseData createCategory(CategoryRequest categoryRequest);
    Page<Category> findCategory(Pageable pageable);
}
