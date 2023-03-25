package com.tshine.common.dto.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ModuleResponse {
    private String id;
    private String code;
    private String name;
    private String description;
    private String status;
    private String icon;
    @JsonBackReference
    private ModuleResponse pModule;
    @JsonManagedReference
    private List<ModuleResponse> modules;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ModuleResponse getpModule() {
        return pModule;
    }

    public void setpModule(ModuleResponse pModule) {
        this.pModule = pModule;
    }

    public List<ModuleResponse> getModules() {
        return modules;
    }

    public void setModules(List<ModuleResponse> modules) {
        this.modules = modules;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
