package com.tshine.server.apiserver.service;

import com.tshine.server.apiserver.entities.system.SystemModule;
import com.tshine.server.common.dto.user.ModuleRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

public interface ModuleService {
    SystemModule createModule(ModuleRequest moduleRequest) throws Exception;
    Page<SystemModule> findModuleByCodes(List<String> codes, Pageable pageable);
    SystemModule findModuleByCode(String code);
    Page<SystemModule> findAllModule(Pageable pageable);
}
