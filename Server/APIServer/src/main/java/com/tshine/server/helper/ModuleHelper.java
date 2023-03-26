package com.tshine.server.helper;

import com.tshine.common.dto.base.Response;
import com.tshine.common.dto.base.ResponseData;
import com.tshine.common.dto.base.ResponseResult;
import com.tshine.common.dto.user.ModuleRequest;
import com.tshine.common.dto.user.ModuleResponse;
import com.tshine.common.entities.system.SystemModule;
import com.tshine.common.utils.AppUtils;
import com.tshine.common.utils.PagingUtils;
import com.tshine.common.utils.ResponseResultUtils;
import com.tshine.service.service.ModuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.tshine.common.constants.AppConstants.FAIL_CODE;
import static com.tshine.common.constants.AppConstants.SUCC_CODE;
import static com.tshine.common.constants.MessageConstants.*;

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
            responseResult = ResponseResultUtils.getResponseResult(CREATE_SUCC, SUCC_CODE);
        }catch (Exception e){
            logger.error("****************ModuleHelper ERROR createModule()***************", e);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_FAIL, FAIL_CODE);
            responseData = null;
        }
        response.setResponse(responseData);
        response.setResult(responseResult);
        return response;
    }


    public Response findModule(Map<String,String> map, Pageable pageable, boolean isPaging) {
        ResponseData responseData = new ResponseData();
        ResponseResult responseResult;
        try {
            Page<SystemModule> modules = moduleService.findAllModule(pageable);
            Object moduleResponse = AppUtils.converToDTO(modules.getContent(), ModuleResponse[].class);
            responseData.setData(moduleResponse);
            responseResult = ResponseResultUtils.getResponseResult(SUCC_KEY, SUCC_CODE);
            if(isPaging){
                PagingUtils.setDataResponse(responseData, modules);
            }
        }catch (Exception e){
            logger.error("****************ModuleHelper ERROR createModule()***************", e);
            responseResult = ResponseResultUtils.getResponseResult(FAIL_KEY, FAIL_CODE);
            responseData = null;
        }
        response.setResponse(responseData);
        response.setResult(responseResult);
        return response;
    }


}
