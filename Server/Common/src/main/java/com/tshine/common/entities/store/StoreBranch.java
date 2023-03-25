package com.tshine.common.entities.store;



import com.tshine.common.constants.AppConstants;
import com.tshine.common.factory.KeyGenarator;
import com.tshine.common.utils.TimeUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
@Entity(name = "store_branchs")
public class StoreBranch {
    @Id
    private String branchId;
    private String address;
    private String name;
    private String hotline;
    private String email;
    private Timestamp createdTime;
    private Timestamp lastUpdated;
    private String createdBy;
    private String updatedBy;
    private String status;

    public StoreBranch() {
        this.branchId = KeyGenarator.getKey();
        this.createdTime = TimeUtils.getTimestampNow();
        this.lastUpdated = TimeUtils.getTimestampNow();
        this.status = AppConstants.STATUS_ACTIVE;
    }

    public String getBranchId() {
        return branchId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
