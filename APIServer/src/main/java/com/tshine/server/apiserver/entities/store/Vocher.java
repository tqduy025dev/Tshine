package com.tshine.server.apiserver.entities.store;

import com.tshine.server.apiserver.common.constants.AppConstants;
import com.tshine.server.apiserver.common.factory.KeyGenarator;
import com.tshine.server.apiserver.common.utils.TimeUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity(name = "vochers")
public class Vocher {
    @Id
    private String vocherId;
    private String title;
    private String description;
    private String type;
    private Double reducedPrice;
    private Double reducedRate;
    private Double reducedMax;
    private Double billCondition;
    private Timestamp createdTime;
    private Timestamp lastUpdated;
    private Timestamp effectiveTime;
    private Timestamp expirationTime;
    private String createdBy;
    private String updatedBy;
    private String status;
    private String branchNo;

    public Vocher() {
        this.vocherId = KeyGenarator.getKey();
        this.createdTime = TimeUtils.getTimestampNow();
        this.lastUpdated = TimeUtils.getTimestampNow();
        this.status = AppConstants.STATUS_ACTIVE;
    }

    public String getVocherId() {
        return vocherId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Double getReducedMax() {
        return reducedMax;
    }

    public void setReducedMax(Double reducedMax) {
        this.reducedMax = reducedMax;
    }

    public Double getBillCondition() {
        return billCondition;
    }

    public void setBillCondition(Double billCondition) {
        this.billCondition = billCondition;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Timestamp effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Timestamp getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Timestamp expirationTime) {
        this.expirationTime = expirationTime;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
