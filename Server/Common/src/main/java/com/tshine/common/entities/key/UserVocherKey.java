package com.tshine.common.entities.key;


import com.tshine.common.factory.KeyGenarator;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserVocherKey implements Serializable {
    @Column
    private String userId;
    @Column
    private String vocherId;

    public UserVocherKey() {
        this.userId = KeyGenarator.getKey();
        this.vocherId = KeyGenarator.getKey();
    }

    public String getUserId() {
        return userId;
    }

    public String getVocherId() {
        return vocherId;
    }

}
