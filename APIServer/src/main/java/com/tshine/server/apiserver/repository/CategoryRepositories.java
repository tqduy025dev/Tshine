package com.tshine.server.apiserver.repository;

import com.tshine.server.apiserver.entities.product.Category;
import com.tshine.server.apiserver.entities.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepositories extends JpaRepository<Category, String> {
    List<Category> findCategoryByCategoryIdIn(List<String> ids);}
