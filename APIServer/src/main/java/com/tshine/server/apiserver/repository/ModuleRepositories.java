package com.tshine.server.apiserver.repository;

import com.tshine.server.apiserver.entities.system.SystemModule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepositories extends JpaRepository<SystemModule, String> {
    List<SystemModule> findSystemModulesByCodeIn(List<String> codes);
    SystemModule findSystemModuleByCode(String codes);
}
