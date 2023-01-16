package com.tshine.server.apiserver.service.impl;

import com.tshine.server.apiserver.entities.product.Category;
import com.tshine.server.apiserver.repository.CategoryRepositories;
import com.tshine.server.apiserver.service.CategoryService;
import com.tshine.server.common.dto.base.BaseData;
import com.tshine.server.common.dto.product.CategoryRequest;
import com.tshine.server.common.utils.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CategoryRepositories categoryRepositories;

    public CategoryServiceImpl(CategoryRepositories categoryRepositories) {
        this.categoryRepositories = categoryRepositories;
    }


    @Override
    public List<Category> findCategoryByIds(List<String> ids) {
        return categoryRepositories.findCategoryByCategoryIdIn(ids);
    }

    @Override
    public BaseData createCategory(CategoryRequest categoryRequest) {
        BaseData baseData = new BaseData();
        try {
            Category category = (Category) AppUtils.converToEntities(categoryRequest, Category.class);
            Category result = categoryRepositories.save(category);
            baseData.setResult(result);
        }catch (Exception e){
            logger.error("============CategoryServiceImpl ERROR createCategory()", e);
            baseData.setError(true);
        }
        return baseData;
    }

    @Override
    public Category findCategoryById(String id) {
        return categoryRepositories.findById(id).orElse(null);
    }


    @Override
    public Page<Category> findCategory(Pageable pageable) {
        return categoryRepositories.findAll(pageable);
    }


}
