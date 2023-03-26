package com.tshine.service.repository;

import com.tshine.common.entities.role.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepositories extends JpaRepository<Permission, String> {
    List<Permission> findPermissionsByCodeIn(List<String> codes);
    Permission findPermissionsByCode(String codes);
}
