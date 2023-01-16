package com.tshine.server.apiserver.service;

import com.tshine.server.apiserver.entities.product.Category;
import com.tshine.server.common.dto.base.BaseData;
import com.tshine.server.common.dto.product.CategoryRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> findCategoryByIds(List<String> ids);
    Category findCategoryById(String id);
    BaseData createCategory(CategoryRequest categoryRequest);
    Page<Category> findCategory(Pageable pageable);
}
