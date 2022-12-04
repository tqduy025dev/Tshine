package com.tshine.server.apiserver.service.impl;

import com.tshine.server.apiserver.entities.system.SystemModule;
import com.tshine.server.apiserver.repository.ModuleRepositories;
import com.tshine.server.apiserver.service.AmazonClientService;
import com.tshine.server.apiserver.service.ModuleService;
import com.tshine.server.common.dto.user.ModuleRequest;
import com.tshine.server.common.utils.AppUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepositories moduleRepositories;
    private final AmazonClientService amazonClientService;

    public ModuleServiceImpl(ModuleRepositories moduleRepositories, AmazonClientService amazonClientService) {
        this.moduleRepositories = moduleRepositories;
        this.amazonClientService = amazonClientService;
    }


    @Override
    public SystemModule createModule(ModuleRequest moduleRequest) throws Exception {
        String url = amazonClientService.uploadFileToS3(moduleRequest.getIcon());
        SystemModule systemModule = (SystemModule) AppUtils.converToEntities(moduleRequest, SystemModule.class);
        systemModule.setpModule(null);
        if(StringUtils.isNotEmpty(moduleRequest.getpModule())){
            SystemModule pModule = moduleRepositories.findById(moduleRequest.getpModule()).orElseThrow(Exception::new);
            systemModule.setpModule(pModule);
        }
        systemModule.setIcon(url);
        return moduleRepositories.save(systemModule);
    }

    @Override
    public Page<SystemModule> findModuleByCodes(List<String> codes, Pageable pageable) {
        return moduleRepositories.findSystemModulesByCodeIn(codes, pageable);
    }

    @Override
    public SystemModule findModuleByCode(String code) {
        return moduleRepositories.findSystemModuleByCode(code);
    }

    @Override
    public Page<SystemModule> findAllModule(Pageable pageable) {
        return moduleRepositories.findAll(pageable);
    }
}
