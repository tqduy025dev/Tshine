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
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public static void removeValueEmptyToMap(Map<String, String> map) {
        for (String key : map.keySet()) {
            String SubSpace = map.get(key).trim().replaceAll("\\s+"," ");
            map.put(key, SubSpace);
            if(StringUtils.isEmpty(map.get(key)) || map.get(key).trim().isEmpty()){
                map.remove(key);
            }
        }
    }
}
