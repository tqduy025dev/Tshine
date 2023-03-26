package com.tshine.service.repository;

import com.tshine.common.entities.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositories extends JpaRepository<Role, String> {
    Role findRoleByCodeEquals(String code);
}
