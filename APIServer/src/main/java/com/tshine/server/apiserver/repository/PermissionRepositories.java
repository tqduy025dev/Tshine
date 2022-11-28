package com.tshine.server.apiserver.repository;

import com.tshine.server.apiserver.entities.role.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepositories extends JpaRepository<Permission, String> {
    Page<Permission> findPermissionsByCodeIn(List<String> codes, Pageable pageable);
    Permission findPermissionsByCode(String codes);
}
