package com.tshine.common.entities.bill;

import com.tshine.common.entities.product.Product;
import com.tshine.common.factory.KeyGenarator;

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
