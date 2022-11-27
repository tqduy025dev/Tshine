package com.tshine.server.apiserver.entities.bill;

import com.tshine.server.apiserver.common.factory.KeyGenarator;
import com.tshine.server.apiserver.entities.product.Product;

import javax.persistence.*;

@Entity(name = "bill_payment_infos")
public class BillPaymentInfo {
    @Id
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private BillPaymentHistory bill;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer orderAmount;

    public BillPaymentInfo() {
        this.id = KeyGenarator.getKey();
    }

    public String getId() {
        return id;
    }

    public BillPaymentHistory getBill() {
        return bill;
    }

    public void setBill(BillPaymentHistory bill) {
        this.bill = bill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }
}
