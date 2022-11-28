package com.tshine.server.controller.helper;

import com.tshine.server.apiserver.authority.MyUserDetail;
import com.tshine.server.apiserver.entities.user.UserInfo;
import com.tshine.server.apiserver.service.UserService;
import com.tshine.server.common.dto.base.Response;
import com.tshine.server.common.dto.base.ResponseData;
import com.tshine.server.common.dto.base.ResponseResult;
import com.tshine.server.common.dto.user.UserRequest;
import com.tshine.server.common.dto.user.UserResponse;
import com.tshine.server.common.utils.AppUtils;
import com.tshine.server.common.utils.PagingUtils;
import com.tshine.server.common.utils.ResponseResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.tshine.server.common.constants.AppConstants.*;
import static com.tshine.server.common.constants.MessageConstants.*;

@Service
public class UserHelper {
    private final Logger logger = LoggerFactory.getLogger(UserHelper.class);

    private final UserService userService;
    private final Response response = new Response();

    public UserHelper(UserService userService) {
        this.userService = userService;
    }

    public Response createEmployee(UserRequest userRequest){
        ResponseResult responseResult;
        ResponseData responseData = new ResponseData();
        try {
            UserInfo result = userService.createUser(userRequest);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_SUCC, CODE_SUCC);
            Object userResponse = AppUtils.converToDTO(result, UserResponse.class);
            responseData.setData(userResponse);
        }catch (Exception e){
            logger.error("******UserHelper Error createEmployee()******", e);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_FAIL, CODE_FAIL);
            responseData = null;
        }
        response.setResponse(responseData);
        response.setResult(responseResult);
        return response;
    }

    public Response authorizeUser(Authentication authentication){
        ResponseResult responseResult = null;
        ResponseData responseData = new ResponseData();
        try {
            if (authentication.isAuthenticated()) {
                MyUserDetail myUserDetail = (MyUserDetail) authentication.getPrincipal();
                UserInfo userInfo = myUserDetail.getUserInfo();
                Object employeeResponse = AppUtils.converToDTO(userInfo, UserResponse.class);
                responseData.setData(employeeResponse);
                responseResult = ResponseResultUtils.getResponseResult(SUCC_KEY, CODE_SUCC);
            }
        }catch (Exception e){
            logger.error("******UserHelper Error authorizeUser()******", e);
            responseResult = ResponseResultUtils.getResponseResult(FAIL_KEY, CODE_UNAUTHORIZED);
        }
        response.setResult(responseResult);
        response.setResponse(responseData);
        return response;
    }

    public Response findUser(Map<String, String> map, Pageable pageable){
        ResponseResult responseResult;
        ResponseData responseData = new ResponseData();
        try {
            Page<UserInfo> result = userService.findUser(map,pageable);
            Object userResponse = AppUtils.converToDTO(result.getContent(), UserResponse[].class);
            PagingUtils.setDataResponse(responseData, result);
            responseData.setData(userResponse);
            responseResult = ResponseResultUtils.getResponseResult(SUCC_KEY, CODE_SUCC);
        }catch (Exception e){
            logger.error("******UserHelper Error findEmployee()******", e);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_FAIL, CODE_FAIL);
            responseData = null;
        }
        response.setResponse(responseData);
        response.setResult(responseResult);
        return response;
    }
}
