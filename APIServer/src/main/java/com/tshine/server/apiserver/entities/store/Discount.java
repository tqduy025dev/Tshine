package com.tshine.server.apiserver.entities.store;

import com.tshine.server.apiserver.entities.product.Product;
import com.tshine.server.common.constants.AppConstants;
import com.tshine.server.common.factory.KeyGenarator;
import com.tshine.server.common.utils.TimeUtils;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "discounts")
public class Discount {
    @Id
    private String discountId;
    private String code;
    private String title;
    private String description;
    private Integer amount;
    private Double reducedPrice;
    private Double reducedRate;
    private Timestamp createdTime;
    @UpdateTimestamp
    private Timestamp lastUpdated;
    private String createdBy;
    private String updatedBy;
    private String status;
    private String branchNo;
    @OneToMany(mappedBy = "discount")
    private List<Product> products;

    public Discount() {
        this.discountId = KeyGenarator.getKey();
        this.createdTime = TimeUtils.getTimestampNow();
        this.status = AppConstants.STATUS_ACTIVE;
    }

    public String getDiscountId() {
        return discountId;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(Double reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public Double getReducedRate() {
        return reducedRate;
    }

    public void setReducedRate(Double reducedRate) {
        this.reducedRate = reducedRate;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
