package com.tshine.service.service.impl;

import com.tshine.common.dto.user.ModuleRequest;
import com.tshine.common.entities.system.SystemModule;
import com.tshine.common.utils.AppUtils;
import com.tshine.service.repository.ModuleRepositories;
import com.tshine.service.service.AmazonClientService;
import com.tshine.service.service.ModuleService;
import com.tshine.service.service.SystemFileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepositories moduleRepositories;
    private final AmazonClientService amazonClientService;
    private final SystemFileService systemFileService;
    @Value("${directory.location}")
    private String pathDirectory;

    public ModuleServiceImpl(ModuleRepositories moduleRepositories, AmazonClientService amazonClientService, SystemFileService systemFileService) {
        this.moduleRepositories = moduleRepositories;
        this.amazonClientService = amazonClientService;
        this.systemFileService = systemFileService;
    }


    @Override
    public SystemModule createModule(ModuleRequest moduleRequest) throws Exception {
//        String url = amazonClientService.uploadFileToS3(moduleRequest.getIcon());
        String url = systemFileService.saveFileToStorage(moduleRequest.getIcon(), pathDirectory, "module");
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
    public List<SystemModule> findModuleByCodes(List<String> codes) {
        return moduleRepositories.findSystemModulesByCodeIn(codes);
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
