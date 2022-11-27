package com.tshine.server.apiserver.common.utils;

import com.tshine.server.apiserver.authority.JwtTokenProvider;
import com.tshine.server.apiserver.common.dto.base.FileResponse;
import com.tshine.server.apiserver.common.dto.employee.UserResponse;
import com.tshine.server.apiserver.common.dto.user.PermissionResponse;
import com.tshine.server.apiserver.common.dto.user.RoleResponse;
import com.tshine.server.apiserver.entities.role.Permission;
import com.tshine.server.apiserver.entities.role.Role;
import com.tshine.server.apiserver.entities.user.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class AppUtils {
    public static String getCurrentUser(){
        return JwtTokenProvider.getInstance().getUserIdFromAuth();
    }

    public static UserResponse getEmployeeResponse(UserInfo userInfo) {
        UserResponse userResponse = new UserResponse();
        FileResponse fileResponse = new FileResponse();
        fileResponse.setType(userInfo.getImage().getType());
        fileResponse.setData(userInfo.getImage().getUrl());
        fileResponse.setId(userInfo.getImage().getId());

        userResponse.setAddress(userInfo.getAddress());
        userResponse.setPhone(userInfo.getMobile());
        userResponse.setFirstName(userInfo.getFirstName());
        userResponse.setLastName(userInfo.getLastName());
        userResponse.setEmail(userInfo.getEmail());
        userResponse.setDayOfbirth(userInfo.getDateOfBirth());
        userResponse.setId(userInfo.getUserId());
        userResponse.setGender(userInfo.getGender());
        userResponse.setCreateTime(TimeUtils.parseString(userInfo.getCreatedTime()));
        userResponse.setStatus(userInfo.getStatus());
        userResponse.setImage(fileResponse);

        return userResponse;
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
