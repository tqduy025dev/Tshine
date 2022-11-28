package com.tshine.server.common.utils;

import com.tshine.server.apiserver.authority.JwtTokenProvider;
import com.tshine.server.common.converter.StringToTimestampConverter;
import com.tshine.server.common.converter.TimestampToStringConverter;
import com.tshine.server.common.dto.user.UserResponse;
import com.tshine.server.common.dto.user.PermissionResponse;
import com.tshine.server.common.dto.user.RoleResponse;
import com.tshine.server.apiserver.entities.role.Permission;
import com.tshine.server.apiserver.entities.role.Role;
import com.tshine.server.apiserver.entities.user.UserInfo;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class AppUtils {
    public static String getCurrentUser(){
        return JwtTokenProvider.getInstance().getUserIdFromAuth();
    }

    public static Object converToDTO(Object object, Class<?> clazz) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new TimestampToStringConverter());
        return modelMapper.map(object, clazz);
    }

    public static Object converToEntities(Object object, Class<?> clazz) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new StringToTimestampConverter());
        return modelMapper.map(object, clazz);
    }


    public static RoleResponse getRoleResponse(Role role){
        RoleResponse roleResponse = new RoleResponse();
        List<PermissionResponse> permissionResponses = new ArrayList<>();
        roleResponse.setId(role.getRoleId());
        roleResponse.setCode(role.getCode());
        roleResponse.setName(role.getName());
        roleResponse.setStatus(role.getStatus());
        roleResponse.setDescription(role.getDescription());
        role.getPermissions().forEach(i -> {
            PermissionResponse permissionResponse = new PermissionResponse();
            permissionResponse.setId(i.getPermissionId());
            permissionResponse.setName(i.getName());
            permissionResponse.setCode(i.getCode());
            permissionResponse.setDescription(i.getDescription());
            permissionResponse.setStatus(i.getStatus());
            permissionResponses.add(permissionResponse);
        });
        roleResponse.setPermissions(permissionResponses);
        return roleResponse;
    }


    public static PermissionResponse getPermissionResponse(Permission permision){
        PermissionResponse permissionResponse = new PermissionResponse();
        permissionResponse.setStatus(permision.getStatus());
        permissionResponse.setName(permision.getName());
        permissionResponse.setCode(permision.getCode());
        permissionResponse.setDescription(permision.getDescription());
        permissionResponse.setId(permision.getPermissionId());
        return permissionResponse;
    }
}
