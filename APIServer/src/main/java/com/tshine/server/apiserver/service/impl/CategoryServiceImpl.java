package com.tshine.server.apiserver.service.impl;

import com.tshine.server.apiserver.entities.product.Category;
import com.tshine.server.apiserver.entities.product.Product;
import com.tshine.server.apiserver.repository.CategoryRepositories;
import com.tshine.server.apiserver.service.CategoryService;
import com.tshine.server.common.dto.product.CategoryRequest;
import com.tshine.server.common.utils.AppUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepositories categoryRepositories;

    public CategoryServiceImpl(CategoryRepositories categoryRepositories) {
        this.categoryRepositories = categoryRepositories;
    }


    @Override
    public List<Category> findCategoryByIds(List<String> ids) {
        return categoryRepositories.findCategoryByCategoryIdIn(ids);
    }

    @Override
    public Category createCategory(CategoryRequest categoryRequest) {
        Category category = (Category) AppUtils.converToEntities(categoryRequest, Category.class);
        return categoryRepositories.save(category);
    }

    @Override
    public Category findCategoryById(String id) {
        return categoryRepositories.findById(id).orElse(null);
    }


    @Override
    public Page<Category> findAllCategory(Pageable pageable) {
        return categoryRepositories.findAll(pageable);
    }


}
