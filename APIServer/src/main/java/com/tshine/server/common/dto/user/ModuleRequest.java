package com.tshine.server.common.dto.user;

import org.springframework.web.multipart.MultipartFile;

public class ModuleRequest {
    private String code;
    private String name;
    private String description;
    private MultipartFile icon;
    private Integer seqNo;
    private String pModule;

    public ModuleRequest() {
        this.seqNo = -1;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getIcon() {
        return icon;
    }

    public void setIcon(MultipartFile icon) {
        this.icon = icon;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getpModule() {
        return pModule;
    }

    public void setpModule(String pModule) {
        this.pModule = pModule;
    }
}
