package com.tshine.server.apiserver.entities.system;

import com.tshine.server.common.constants.AppConstants;
import com.tshine.server.common.factory.KeyGenarator;
import com.tshine.server.common.utils.TimeUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity(name = "system_files")
public class SystemFile {
    @Id
    private String id;
    private String url;
    private String type;
    private Timestamp createdTime;
    private String createdBy;
    private String status;

    public SystemFile() {
        this.id = KeyGenarator.getKey();
        this.createdTime = TimeUtils.getTimestampNow();
        this.status = AppConstants.STATUS_ACTIVE;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
