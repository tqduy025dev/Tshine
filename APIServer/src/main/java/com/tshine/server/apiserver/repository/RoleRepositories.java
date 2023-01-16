package com.tshine.server.apiserver.repository;

import com.tshine.server.apiserver.entities.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositories extends JpaRepository<Role, String> {
    Role findRoleByCodeEquals(String code);
}
