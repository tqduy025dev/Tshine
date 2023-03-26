package com.tshine.service.repository;

import com.tshine.common.entities.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepositories extends JpaRepository<Category, String> {
    List<Category> findCategoryByCategoryIdIn(List<String> ids);}
