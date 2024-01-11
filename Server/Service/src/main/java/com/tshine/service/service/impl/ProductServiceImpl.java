package com.tshine.service.service.impl;

import com.tshine.common.dto.product.ProductRequest;
import com.tshine.common.entities.product.Category;
import com.tshine.common.entities.product.Product;
import com.tshine.common.entities.store.Discount;
import com.tshine.common.entities.system.SystemFile;
import com.tshine.common.utils.AppUtils;
import com.tshine.service.repository.ProductRepositories;
import com.tshine.service.service.AmazonClientService;
import com.tshine.service.service.ProductService;
import com.tshine.service.service.SystemFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepositories productRepositories;
    private final AmazonClientService amazonClientService;
    private final SystemFileService systemFileService;

    @Value("${directory.location}")
    private String pathDirectory;
    public ProductServiceImpl(ProductRepositories productRepositories, AmazonClientService amazonClientService, SystemFileService systemFileService) {
        this.productRepositories = productRepositories;
        this.amazonClientService = amazonClientService;
        this.systemFileService = systemFileService;
    }

    @Override
    public Product createProduct(ProductRequest productRequest, List<Category> categories, Discount discount) throws IOException {
//        List<SystemFile> systemFiles = amazonClientService.uploadFileToS3(productRequest.getImages());
        List<SystemFile> systemFiles = systemFileService.saveFileToStorage(productRequest.getImages(), pathDirectory);
        Product product = (Product) AppUtils.converToEntities(productRequest, Product.class);
        product.setImages(systemFiles);
        product.setCategories(categories);
        product.setDiscount(discount);
        return productRepositories.save(product);
    }

    @Override
    public Product findProductById(String id) {
        return productRepositories.findById(id).orElse(null);
    }

    @Override
    @Query
    public Page<Product> findProductByCategory(String catygoryId, Pageable pageable) {
        return productRepositories.findProductByCategoriesCategoryId(catygoryId, pageable);
    }

    @Override
    public Page<Product> findAllProduct(Pageable pageable) {
        return productRepositories.findAll(pageable);
    }
}
