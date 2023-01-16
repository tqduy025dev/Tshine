package com.tshine.server.apiserver.entities.bill;

import com.tshine.server.apiserver.entities.store.Vocher;
import com.tshine.server.common.factory.KeyGenarator;
import com.tshine.server.common.utils.TimeUtils;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "bill_payment_historys")
public class BillPaymentHistory {
    @Id
    private String billId;
    @Column(nullable = false)
    private String orderBy;
    private Double amount;
    private Double total;
    @Column(nullable = false)
    private String branchNo;
    private Timestamp createdTime;
    private String createdBy;
    @OneToOne
    @JoinColumn(name = "vocher_id")
    private Vocher vocher;


    public BillPaymentHistory() {
        this.billId = KeyGenarator.getKey();
        this.createdTime = TimeUtils.getTimestampNow();
    }

    public String getBillId() {
        return billId;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Vocher getVocher() {
        return vocher;
    }

    public void setVocher(Vocher vocher) {
        this.vocher = vocher;
    }
}
