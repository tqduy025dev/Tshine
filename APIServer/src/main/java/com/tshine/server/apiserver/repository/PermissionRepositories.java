package com.tshine.server.apiserver.repository;

import com.tshine.server.apiserver.entities.role.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepositories extends JpaRepository<Permission, String> {
}
