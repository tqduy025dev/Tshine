package com.tshine.server.apiserver.repository;

import com.tshine.common.entities.role.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepositories extends JpaRepository<Permission, String> {
    List<Permission> findPermissionsByCodeIn(List<String> codes);
    Permission findPermissionsByCode(String codes);
}
