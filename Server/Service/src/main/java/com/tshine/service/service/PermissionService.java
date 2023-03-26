package com.tshine.service.service;

import com.tshine.common.dto.user.PermissionRequest;
import com.tshine.common.entities.role.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PermissionService {
    Permission createPermission(PermissionRequest permissionRequest);
    List<Permission> findPermissionByCodes(List<String> codes);
    Permission findPermissionByCodes(String code);
    Page<Permission> findAllPermission(Pageable pageable);
}
