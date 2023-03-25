package com.tshine.common.dto.user;

import java.util.List;

public class RoleResponse {
    private String id;
    private String code;
    private String name;
    private String description;
    private String status;
    private List<PermissionResponse> permissions;
    private List<ModuleResponse> modules;

    public List<PermissionResponse> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionResponse> permissions) {
        this.permissions = permissions;
    }

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

    public List<ModuleResponse> getModules() {
        return modules;
    }

    public void setModules(List<ModuleResponse> modules) {
        this.modules = modules;
    }
}
