package com.tshine.server.helper;


import com.tshine.server.apiserver.entities.role.Permission;
import com.tshine.server.apiserver.entities.role.Role;
import com.tshine.server.apiserver.entities.system.SystemModule;
import com.tshine.server.apiserver.service.ModuleService;
import com.tshine.server.apiserver.service.PermissionService;
import com.tshine.server.apiserver.service.RoleService;
import com.tshine.server.common.dto.base.Response;
import com.tshine.server.common.dto.base.ResponseData;
import com.tshine.server.common.dto.base.ResponseResult;
import com.tshine.server.common.dto.user.PermissionRequest;
import com.tshine.server.common.dto.user.PermissionResponse;
import com.tshine.server.common.dto.user.RoleRequest;
import com.tshine.server.common.dto.user.RoleResponse;
import com.tshine.server.common.utils.AppUtils;
import com.tshine.server.common.utils.PagingUtils;
import com.tshine.server.common.utils.ResponseResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Map;

import static com.tshine.server.common.constants.AppConstants.CODE_FAIL;
import static com.tshine.server.common.constants.AppConstants.CODE_SUCC;
import static com.tshine.server.common.constants.MessageConstants.*;


@Service
public class PermissionHelper {
    private final Logger logger = LoggerFactory.getLogger(PermissionHelper.class);

    private final RoleService roleService;
    private final PermissionService permissionService;
    private final ModuleService moduleService;

    private final Response response = new Response();

    public PermissionHelper(RoleService roleService, PermissionService permissionService, ModuleService moduleService) {
        this.roleService = roleService;
        this.permissionService = permissionService;
        this.moduleService = moduleService;
    }


    public Response createRole(RoleRequest roleRequest){
        ResponseData responseData = new ResponseData();
        ResponseResult responseResult = null;
        try {
            Pageable pageable = Pageable.unpaged();
            Page<Permission> permissions = permissionService.findPermissionByCodes(roleRequest.getPermissions(), pageable);
            Page<SystemModule> modules = moduleService.findModuleByCodes(roleRequest.getModules(), pageable);
            if(!CollectionUtils.isEmpty(permissions.getContent()) && !CollectionUtils.isEmpty(modules.getContent())){
                Role result = roleService.createRole(roleRequest, permissions.getContent(), modules.getContent());
                Object roleResponse = AppUtils.converToDTO(result, RoleResponse.class);
                responseData.setData(roleResponse);
                responseResult = ResponseResultUtils.getResponseResult(CREATE_SUCC, CODE_SUCC);
            }else{
                responseResult = ResponseResultUtils.getResponseResult(CREATE_FAIL, CODE_FAIL);
            }

        }catch (Exception e){
            logger.error("****************RoleHelper ERROR createRole()***************", e);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_FAIL, CODE_FAIL);
            responseData = null;
        }

        response.setResponse(responseData);
        response.setResult(responseResult);
        return response;
    }

    public Response createPermission(PermissionRequest permissionRequest){
        ResponseData responseData = new ResponseData();
        ResponseResult responseResult;
        try {
            Permission result = permissionService.createPermission(permissionRequest);
            Object permissionResponse = AppUtils.converToDTO(result, PermissionResponse.class);
            responseData.setData(permissionResponse);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_SUCC, CODE_SUCC);
        }catch (Exception e){
            logger.error("****************RoleHelper ERROR createPermission()***************", e);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_FAIL, CODE_FAIL);
            responseData = null;
        }
        response.setResponse(responseData);
        response.setResult(responseResult);
        return response;
    }

    public Response findRolePermission(String func,Map<String, String> map, Pageable pageable){
        ResponseResult responseResult;
        try {
            switch (func){
                case "permission" :
                    ResponseData permissionResponses = this.findAllPermission(pageable);
                    response.setResponse(permissionResponses);
                    break;
                case "role" :
                    ResponseData roleResponses = this.findAllRole(pageable);
                    response.setResponse(roleResponses);
                    break;
            }
            responseResult = ResponseResultUtils.getResponseResult(SUCC_KEY, CODE_SUCC);
        }catch (Exception e){
            logger.error("****************RoleHelper ERROR createPermission()***************", e);
            responseResult = ResponseResultUtils.getResponseResult(FAIL_KEY, CODE_FAIL);
        }

        response.setResult(responseResult);
        return response;
    }

    private ResponseData findAllRole(Pageable pageable) {
        ResponseData responseData = new ResponseData();
        Page<Role> roles = roleService.findAllRole(pageable);
        Object roleResponses = AppUtils.converToDTO(roles.getContent(), RoleResponse[].class);
        PagingUtils.setDataResponse(responseData, roles);
        responseData.setData(roleResponses);
        return responseData;
    }

    private ResponseData findAllPermission(Pageable pageable){
        ResponseData responseData = new ResponseData();
        Page<Permission> permissions = permissionService.findAllPermission(pageable);
        Object permissionResponses = AppUtils.converToDTO(permissions.getContent(), PermissionResponse[].class);
        PagingUtils.setDataResponse(responseData, permissions);
        responseData.setData(permissionResponses);
        return responseData;
    }




}
