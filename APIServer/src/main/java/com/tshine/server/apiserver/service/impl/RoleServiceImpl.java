package com.tshine.server.apiserver.service.impl;

import com.tshine.server.apiserver.entities.role.Permission;
import com.tshine.server.apiserver.entities.role.Role;
import com.tshine.server.apiserver.entities.system.SystemModule;
import com.tshine.server.apiserver.repository.RoleRepositories;
import com.tshine.server.apiserver.service.ModuleService;
import com.tshine.server.apiserver.service.PermissionService;
import com.tshine.server.apiserver.service.RoleService;
import com.tshine.server.common.dto.user.RoleRequest;
import com.tshine.server.common.utils.AppUtils;
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
