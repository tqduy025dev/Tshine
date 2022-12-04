package com.tshine.server.apiserver.service.impl;

import com.tshine.server.apiserver.entities.product.Category;
import com.tshine.server.apiserver.entities.product.Product;
import com.tshine.server.apiserver.entities.store.Discount;
import com.tshine.server.apiserver.entities.system.SystemFile;
import com.tshine.server.apiserver.repository.ProductRepositories;
import com.tshine.server.apiserver.service.AmazonClientService;
import com.tshine.server.apiserver.service.ProductService;
import com.tshine.server.common.dto.product.ProductRequest;
import com.tshine.server.common.utils.AppUtils;
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


    public ProductServiceImpl(ProductRepositories productRepositories, AmazonClientService amazonClientService) {
        this.productRepositories = productRepositories;
        this.amazonClientService = amazonClientService;
    }

    @Override
    public Product createProduct(ProductRequest productRequest,List<Category> categories, Discount discount) throws IOException {
        List<SystemFile> systemFiles = amazonClientService.uploadFileToS3(productRequest.getImages());
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
