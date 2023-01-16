package com.tshine.server.apiserver.service;

import com.tshine.server.apiserver.entities.role.Role;
import com.tshine.server.common.dto.user.RoleRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService {
    Role createRole(RoleRequest roleRequest);
    Page<Role> findAllRole(Pageable pageable);
    Role findRoleById(String id);
    Role findRoleByCode(String code);
}
