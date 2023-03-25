package com.tshine.server.helper;


import com.tshine.common.entities.role.Permission;
import com.tshine.common.entities.role.Role;
import com.tshine.common.utils.AppUtils;
import com.tshine.common.utils.PagingUtils;
import com.tshine.common.utils.ResponseResultUtils;
import com.tshine.server.apiserver.service.ModuleService;
import com.tshine.server.apiserver.service.PermissionService;
import com.tshine.server.apiserver.service.RoleService;
import com.tshine.common.dto.base.Response;
import com.tshine.common.dto.base.ResponseData;
import com.tshine.common.dto.base.ResponseResult;
import com.tshine.common.dto.user.PermissionRequest;
import com.tshine.common.dto.user.PermissionResponse;
import com.tshine.common.dto.user.RoleRequest;
import com.tshine.common.dto.user.RoleResponse;
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
public class PermissionHelper {
    private final Logger logger = LoggerFactory.getLogger(PermissionHelper.class);

    private final RoleService roleService;
    private final PermissionService permissionService;

    private final Response response = new Response();

    public PermissionHelper(RoleService roleService, PermissionService permissionService, ModuleService moduleService) {
        this.roleService = roleService;
        this.permissionService = permissionService;
    }


    public Response createRole(RoleRequest roleRequest){
        ResponseData responseData = new ResponseData();
        ResponseResult responseResult;
        try {
            Role result = roleService.createRole(roleRequest);
            Object roleResponse = AppUtils.converToDTO(result, RoleResponse.class);
            responseData.setData(roleResponse);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_SUCC, SUCC_CODE);

        }catch (Exception e){
            logger.error("****************RoleHelper ERROR createRole()***************", e);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_FAIL, FAIL_CODE);
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
            responseResult = ResponseResultUtils.getResponseResult(CREATE_SUCC, SUCC_CODE);
        }catch (Exception e){
            logger.error("****************RoleHelper ERROR createPermission()***************", e);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_FAIL, FAIL_CODE);
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
            responseResult = ResponseResultUtils.getResponseResult(SUCC_KEY, SUCC_CODE);
        }catch (Exception e){
            logger.error("****************RoleHelper ERROR createPermission()***************", e);
            responseResult = ResponseResultUtils.getResponseResult(FAIL_KEY, FAIL_CODE);
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
