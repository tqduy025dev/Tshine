package com.tshine.server.helper;


import com.tshine.server.apiserver.authority.JwtTokenProvider;
import com.tshine.server.apiserver.authority.MyUserDetail;
import com.tshine.server.common.dto.authorize.LoginRequest;
import com.tshine.server.common.dto.authorize.LoginResponse;
import com.tshine.server.common.dto.base.Response;
import com.tshine.server.common.dto.base.ResponseData;
import com.tshine.server.common.dto.base.ResponseResult;
import com.tshine.server.common.utils.ResponseResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import static com.tshine.server.common.constants.AppConstants.*;
import static com.tshine.server.common.constants.MessageConstants.LOGIN_FAIL;
import static com.tshine.server.common.constants.MessageConstants.LOGIN_SUCC;


@Service
public class LoginHelper {
    private final Logger logger = LoggerFactory.getLogger(LoginHelper.class);

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    private final Response response = new Response();

    private LoginHelper(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    private Authentication authenticate(String username, String password) throws Exception {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    public Response authorize(LoginRequest loginRequest){
        ResponseResult result;
        ResponseData responseData =  new ResponseData();
        try {
            Authentication authentication = authenticate(loginRequest.getUsername(), loginRequest.getPassword());
            MyUserDetail myUserDetail = (MyUserDetail) authentication.getPrincipal();
            String token = tokenProvider.generateToken(myUserDetail);
            result = ResponseResultUtils.getResponseResult(LOGIN_SUCC, CODE_SUCC);
            responseData.setData(new LoginResponse(token));
        }catch (Exception e){
            logger.error("******Login Error getDataLogin()******", e);
            result = ResponseResultUtils.getResponseResult(LOGIN_FAIL, CODE_UNAUTHORIZED);
        }
        response.setResponse(responseData);
        response.setResult(result);
        return response;
    }


}
