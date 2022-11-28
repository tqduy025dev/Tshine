package com.tshine.server.controller.helper;

import com.tshine.server.apiserver.authority.MyUserDetail;
import com.tshine.server.apiserver.entities.user.UserInfo;
import com.tshine.server.apiserver.service.UserService;
import com.tshine.server.common.dto.base.Response;
import com.tshine.server.common.dto.base.ResponseData;
import com.tshine.server.common.dto.base.ResponseResult;
import com.tshine.server.common.dto.user.UserResponse;
import com.tshine.server.common.utils.AppUtils;
import com.tshine.server.common.utils.ResponseResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import static com.tshine.server.common.constants.AppConstants.FAIL_CODE;
import static com.tshine.server.common.constants.AppConstants.SUCC_CODE;
import static com.tshine.server.common.constants.MessageConstants.FAIL_KEY;
import static com.tshine.server.common.constants.MessageConstants.SUCC_KEY;

@Service
public class UserHelper {
    private final Logger logger = LoggerFactory.getLogger(UserHelper.class);

    private final UserService userService;
    private final Response response = new Response();



    public UserHelper(UserService userService) {
        this.userService = userService;
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
                responseResult = ResponseResultUtils.getResponseResult(SUCC_KEY, SUCC_CODE);
            }
        }catch (Exception e){
            logger.error("******EmployeeHelper Error createEmployee()******", e);
            responseResult = ResponseResultUtils.getResponseResult(FAIL_KEY, FAIL_CODE);
        }
        response.setResult(responseResult);
        response.setResponse(responseData);
        return response;
    }
}
