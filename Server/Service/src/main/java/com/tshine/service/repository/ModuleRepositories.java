package com.tshine.service.repository;

import com.tshine.common.entities.system.SystemModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepositories extends JpaRepository<SystemModule, String> {
    List<SystemModule> findSystemModulesByCodeIn(List<String> codes);
    SystemModule findSystemModuleByCode(String codes);
}
