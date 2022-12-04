package com.tshine.server.common.dto.product;

import com.tshine.server.common.dto.base.FileResponse;

import java.util.List;

public class ProductResponse {
    private String productId;
    private String productCode;
    private String productName;
    private String productDes;
    private Double productPrice;
    private Integer productAmount;
    private Integer productSold;
    private String branchNo;
    private List<FileResponse> images;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public List<FileResponse> getImages() {
        return images;
    }

    public void setImages(List<FileResponse> images) {
        this.images = images;
    }
}
