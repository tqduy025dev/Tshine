package com.tshine.server.apiserver.entities.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tshine.server.apiserver.entities.store.Discount;
import com.tshine.server.apiserver.entities.system.SystemFile;
import com.tshine.server.common.constants.AppConstants;
import com.tshine.server.common.factory.KeyGenarator;
import com.tshine.server.common.utils.TimeUtils;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
    @Id
    private String productId;
    @Column(unique = true)
    private String productCode;
    private String productName;
    private String productDes;
    private Double productPrice;
    private Integer productAmount;
    private Integer productSold;
    private Timestamp createdTime;
    @UpdateTimestamp
    private Timestamp lastUpdated;
    private String createdBy;
    private String updatedBy;
    private String status;
    private String branchNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<SystemFile> images;

    @ManyToMany
    @JoinTable(
            name = "product_catygories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Category> categories;

    public Product() {
        this.productId = KeyGenarator.getKey();
        this.createdTime = TimeUtils.getTimestampNow();
        this.status = AppConstants.STATUS_ACTIVE;
        this.productSold = 0;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDes() {
        return productDes;
    }

    public void setProductDes(String productDes) {
        this.productDes = productDes;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    public Integer getProductSold() {
        return productSold;
    }

    public void setProductSold(Integer productSold) {
        this.productSold = productSold;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public List<SystemFile> getImages() {
        return images;
    }

    public void setImages(List<SystemFile> images) {
        this.images = images;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
