package com.tshine.common.entities.user;

import com.tshine.common.entities.key.UserVocherKey;
import com.tshine.common.entities.store.Vocher;
import com.tshine.common.constants.AppConstants;
import com.tshine.common.utils.TimeUtils;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "user_vochers")
public class UserVocher {
    @EmbeddedId
    private UserVocherKey key;
    private Integer amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("vocherId")
    @JoinColumn(name = "vocher_id")
    private Vocher vocher;

    private Timestamp createdTime;
    @UpdateTimestamp
    private Timestamp lastUpdated;
    private String createdBy;
    private String updatedBy;
    private String status;

    public UserVocher() {
        this.key = new UserVocherKey();
        this.createdTime = TimeUtils.getTimestampNow();
        this.status = AppConstants.STATUS_ACTIVE;
    }

    public UserVocherKey getKey() {
        return key;
    }

    public void setKey(UserVocherKey key) {
        this.key = key;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Vocher getVocher() {
        return vocher;
    }

    public void setVocher(Vocher vocher) {
        this.vocher = vocher;
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
