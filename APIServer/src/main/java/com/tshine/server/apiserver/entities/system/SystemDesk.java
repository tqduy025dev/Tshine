package com.tshine.server.apiserver.entities.system;

import com.tshine.server.common.constants.AppConstants;
import com.tshine.server.common.factory.KeyGenarator;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "system_desks")
public class SystemDesk {
    @Id
    private String id;
    private String status;
    private String qrCode;
    private String deskCode;
    private String branchNo;

    public SystemDesk() {
        this.id = KeyGenarator.getKey();
        this.status = AppConstants.STATUS_ACTIVE;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getDeskCode() {
        return deskCode;
    }

    public void setDeskCode(String deskNum) {
        this.deskCode = deskNum;
    }



    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }
}
