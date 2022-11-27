package com.tshine.server.apiserver.entities.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserVocherKey implements Serializable {
    @Column
    private String userId;
    @Column
    private String vocherId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVocherId() {
        return vocherId;
    }

    public void setVocherId(String vocherId) {
        this.vocherId = vocherId;
    }
}
