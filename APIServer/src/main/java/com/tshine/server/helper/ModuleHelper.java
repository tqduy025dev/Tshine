package com.tshine.server.helper;

import com.tshine.server.apiserver.entities.role.Permission;
import com.tshine.server.apiserver.entities.role.Role;
import com.tshine.server.apiserver.entities.system.SystemModule;
import com.tshine.server.apiserver.service.ModuleService;
import com.tshine.server.common.dto.base.Response;
import com.tshine.server.common.dto.base.ResponseData;
import com.tshine.server.common.dto.base.ResponseResult;
import com.tshine.server.common.dto.user.*;
import com.tshine.server.common.utils.AppUtils;
import com.tshine.server.common.utils.PagingUtils;
import com.tshine.server.common.utils.ResponseResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.tshine.server.common.constants.AppConstants.CODE_FAIL;
import static com.tshine.server.common.constants.AppConstants.CODE_SUCC;
import static com.tshine.server.common.constants.MessageConstants.*;

@Service
public class ModuleHelper {
    private final Logger logger = LoggerFactory.getLogger(PermissionHelper.class);

    private final ModuleService moduleService;
    private final Response response = new Response();


    public ModuleHelper(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    public Response createModule(ModuleRequest moduleRequest){
        ResponseData responseData = new ResponseData();
        ResponseResult responseResult;
        try {
            SystemModule result = moduleService.createModule(moduleRequest);
            Object moduleResponse = AppUtils.converToDTO(result, ModuleResponse.class);
            responseData.setData(moduleResponse);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_SUCC, CODE_SUCC);
        }catch (Exception e){
            logger.error("****************ModuleHelper ERROR createModule()***************", e);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_FAIL, CODE_FAIL);
            responseData = null;
        }
        response.setResponse(responseData);
        response.setResult(responseResult);
        return response;
    }


    public Response findAllModule(Pageable pageable) {
        ResponseData responseData = new ResponseData();
        ResponseResult responseResult;
        try {
            Page<SystemModule> modules = moduleService.findAllModule(pageable);
            Object moduleResponse = AppUtils.converToDTO(modules.getContent(), ModuleResponse[].class);
            PagingUtils.setDataResponse(responseData, modules);
            responseData.setData(moduleResponse);
            responseResult = ResponseResultUtils.getResponseResult(SUCC_KEY, CODE_SUCC);
        }catch (Exception e){
            logger.error("****************ModuleHelper ERROR createModule()***************", e);
            responseResult = ResponseResultUtils.getResponseResult(FAIL_KEY, CODE_FAIL);
            responseData = null;
        }
        response.setResponse(responseData);
        response.setResult(responseResult);
        return response;
    }


}
