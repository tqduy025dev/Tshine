package com.tshine.server.apiserver.service.impl;


import com.tshine.common.dto.user.PermissionRequest;
import com.tshine.common.entities.role.Permission;
import com.tshine.common.utils.AppUtils;
import com.tshine.server.apiserver.repository.PermissionRepositories;
import com.tshine.server.apiserver.service.PermissionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepositories permissionRepositories;

    public PermissionServiceImpl(PermissionRepositories permissionRepositories) {
        this.permissionRepositories = permissionRepositories;
    }

    @Override
    public Permission createPermission(PermissionRequest permissionRequest) {
        Permission permission = (Permission) AppUtils.converToEntities(permissionRequest, Permission.class);
        return permissionRepositories.save(permission);
    }

    @Override
    public List<Permission> findPermissionByCodes(List<String> codes) {
        return permissionRepositories.findPermissionsByCodeIn(codes);
    }

    @Override
    public Permission findPermissionByCodes(String code) {
        return permissionRepositories.findPermissionsByCode(code);
    }

    @Override
    public Page<Permission> findAllPermission(Pageable pageable) {
        return permissionRepositories.findAll(pageable);
    }
}
