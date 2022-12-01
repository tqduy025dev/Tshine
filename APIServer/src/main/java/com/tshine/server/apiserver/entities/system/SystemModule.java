package com.tshine.server.apiserver.entities.system;

import com.tshine.server.apiserver.entities.role.Role;
import com.tshine.server.common.constants.AppConstants;
import com.tshine.server.common.factory.KeyGenarator;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SystemModule {
    @Id
    private String moduleId;
    @Column(unique = true)
    private String code;
    private String name;
    private String status;
    private String description;
    private String icon;
    private Integer seqNo;
    @ManyToOne
    @JoinColumn(name = "p_module_id")
    private SystemModule pModule;

    @OneToMany(mappedBy = "pModule")
    private Set<SystemModule> modules;

    @ManyToMany(mappedBy = "modules",
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    private Set<Role> roles;

    public SystemModule() {
        this.moduleId = KeyGenarator.getKey();
        this.status = AppConstants.STATUS_ACTIVE;
    }

    public String getModuleId() {
        return moduleId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public SystemModule getpModule() {
        return pModule;
    }

    public void setpModule(SystemModule pModule) {
        this.pModule = pModule;
    }

    public Set<SystemModule> getcModules() {
        return modules;
    }

    public void setcModules(Set<SystemModule> cModules) {
        this.modules = cModules;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
