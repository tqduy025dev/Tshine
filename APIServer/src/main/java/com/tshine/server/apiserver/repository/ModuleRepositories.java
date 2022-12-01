package com.tshine.server.apiserver.repository;

import com.tshine.server.apiserver.entities.system.SystemModule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepositories extends JpaRepository<SystemModule, String> {
    Page<SystemModule> findSystemModulesByCodeIn(List<String> codes, Pageable pageable);
    SystemModule findSystemModuleByCode(String codes);
}
