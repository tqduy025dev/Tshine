package com.tshine.server.apiserver.service;

import com.tshine.common.dto.user.ModuleRequest;
import com.tshine.common.entities.system.SystemModule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ModuleService {
    SystemModule createModule(ModuleRequest moduleRequest) throws Exception;
    List<SystemModule> findModuleByCodes(List<String> codes);
    SystemModule findModuleByCode(String code);
    Page<SystemModule> findAllModule(Pageable pageable);
}
