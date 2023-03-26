package com.tshine.service.service.impl;

import com.tshine.common.entities.role.Permission;
import com.tshine.common.entities.role.Role;
import com.tshine.common.entities.system.SystemModule;
import com.tshine.common.utils.AppUtils;
import com.tshine.service.repository.RoleRepositories;
import com.tshine.service.service.ModuleService;
import com.tshine.service.service.PermissionService;
import com.tshine.service.service.RoleService;
import com.tshine.common.dto.user.RoleRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepositories roleRepositories;
    private final ModuleService moduleService;
    private final PermissionService permissionService;


    public RoleServiceImpl(RoleRepositories roleRepositories, ModuleService moduleService, PermissionService permissionService) {
        this.roleRepositories = roleRepositories;
        this.moduleService = moduleService;
        this.permissionService = permissionService;
    }

    @Override
    public Role createRole(RoleRequest roleRequest) {
        List<Permission> permissions = permissionService.findPermissionByCodes(roleRequest.getPermissions());
        List<SystemModule> modules = moduleService.findModuleByCodes(roleRequest.getModules());

        Role role = (Role) AppUtils.converToEntities(roleRequest, Role.class);
        role.setPermissions(permissions);
        role.setModules(modules);
        return roleRepositories.save(role);
    }

    @Override
    public Page<Role> findAllRole(Pageable pageable) {
        return roleRepositories.findAll(pageable);
    }

    @Override
    public Role findRoleById(String id) {
        return roleRepositories.findById(id).orElse(null);
    }

    @Override
    public Role findRoleByCode(String code) {
        return roleRepositories.findRoleByCodeEquals(code);
    }
}
