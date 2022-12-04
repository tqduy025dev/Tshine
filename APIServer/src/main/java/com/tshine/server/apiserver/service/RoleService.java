package com.tshine.server.apiserver.service;

import com.tshine.server.apiserver.entities.role.Permission;
import com.tshine.server.apiserver.entities.role.Role;
import com.tshine.server.apiserver.entities.system.SystemModule;
import com.tshine.server.common.dto.user.RoleRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {
    Role createRole(RoleRequest roleRequest, List<Permission> permissions, List<SystemModule> modules);
    Page<Role> findAllRole(Pageable pageable);
    Role findRoleById(String id);
}
