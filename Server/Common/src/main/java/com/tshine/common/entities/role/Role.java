package com.tshine.common.entities.role;

import com.tshine.common.entities.system.SystemModule;
import com.tshine.common.constants.AppConstants;
import com.tshine.common.factory.KeyGenarator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity(name = "roles")
public class Role {
    @Id
    private String roleId;
    @Column(unique = true)
    private String code;
    private String name;
    private String description;
    private String status;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "permission_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Permission> permissions;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "role_modules",
            joinColumns = @JoinColumn(name = "module_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<SystemModule> modules;

    public Role() {
        this.roleId = KeyGenarator.getKey();
        this.status = AppConstants.STATUS_ACTIVE;
    }

    public String getRoleId() {
        return roleId;
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

    public List<SystemModule> getModules() {
        return modules;
    }

    public void setModules(List<SystemModule> modules) {
        this.modules = modules;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
