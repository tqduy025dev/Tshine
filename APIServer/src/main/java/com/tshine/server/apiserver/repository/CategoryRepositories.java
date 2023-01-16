package com.tshine.server.apiserver.repository;

import com.tshine.server.apiserver.entities.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepositories extends JpaRepository<Category, String> {
    List<Category> findCategoryByCategoryIdIn(List<String> ids);}
