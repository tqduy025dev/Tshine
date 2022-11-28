package com.tshine.server.apiserver.service;

import com.tshine.server.apiserver.entities.role.Permission;
import com.tshine.server.common.dto.user.PermissionRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PermissionService {
    Permission createPermission(PermissionRequest permissionRequest);
    Page<Permission> findPermissionByCode(List<String> codes, Pageable pageable);
    Permission findPermissionByCode(String codes);
    Page<Permission> findAllPermission(Pageable pageable);
}
