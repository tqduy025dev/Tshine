package com.tshine.server.apiserver.entities.product;

import com.tshine.server.apiserver.entities.key.ProductCategoryKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "product_catygories")
public class ProductCategory implements Serializable {
    @EmbeddedId
    private ProductCategoryKey key;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @MapsId("categoryId")
    private Category category;



    public ProductCategoryKey getKey() {
        return key;
    }

    public void setKey(ProductCategoryKey key) {
        this.key = key;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
