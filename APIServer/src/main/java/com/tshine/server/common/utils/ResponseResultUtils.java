package com.tshine.server.common.utils;


import com.tshine.server.common.dto.base.ResponseResult;

import java.util.Map;
import java.util.Objects;

import static com.tshine.server.common.constants.AppConstants.*;
import static com.tshine.server.common.constants.MessageConstants.*;

public class ResponseResultUtils {
    public static ResponseResult getResponseResult(String key, String code) {
        ResponseResult responseResult = new ResponseResult();
        String description = ResourceBundle.getInstance().getName(key);
        ResponseResultUtils.setResponseResult(responseResult, key, code, description);
        return responseResult;
    }

    public static ResponseResult getResponseResult(String status, Map<String, String> error) {
        ResponseResult responseResult;
        switch (status){

            case STATUS_NOT_FOUND:
                responseResult = ResponseResultUtils.getResponseResult(NOT_FOUND_KEY, FAIL_CODE, error);
                break;
            case STATUS_D0:
                responseResult = ResponseResultUtils.getResponseResult(DELETE_SUCC, SUCC_CODE, error);
                break;
            case STATUS_D1:
                responseResult = ResponseResultUtils.getResponseResult(DELETE_FAIL_DELETED, FAIL_CODE, error);
                break;
            case STATUS_D2:
                responseResult = ResponseResultUtils.getResponseResult(DELETE_FAIL_NOT_EXISTS, FAIL_CODE, error);
                break;
            case STATUS_U0:
                responseResult = ResponseResultUtils.getResponseResult(UPDATE_SUCC, SUCC_CODE, error);
                break;
            case STATUS_U2:
                responseResult = ResponseResultUtils.getResponseResult(UPDATE_FAIL_NOT_EXISTS, FAIL_CODE, error);
                break;
            default:
                responseResult = ResponseResultUtils.getResponseResult(FAIL_KEY, FAIL_CODE, error);
                break;
        }
        return responseResult;
    }

    private static void setResponseResult(ResponseResult responseResult, String key, String code, String description) {
        responseResult.setKey(key);
        responseResult.setCode(code);
        responseResult.setDesc(description);
        switch (code){
            case FAIL_CODE:
                responseResult.setHttpStatus(404);
                break;
            case CODE_UNAUTHORIZED:
                responseResult.setHttpStatus(401);
                break;
            case CODE_BAD_REQUEST:
                responseResult.setHttpStatus(400);
                break;
            case CODE_CONFLICT:
                responseResult.setHttpStatus(409);
                break;
            case CODE_CREATED:
                responseResult.setHttpStatus(201);
                break;
            case CODE_ACCEPTED:
                responseResult.setHttpStatus(202);
                break;
            default:
                responseResult.setHttpStatus(200);
        }
    }

    private static ResponseResult getResponseResult(String key, String code, Map<String, String> error) {
        ResponseResult responseResult = new ResponseResult();
        String description = ResourceBundle.getInstance().getName(key);
        if(Objects.nonNull(error)){
            for (Map.Entry<String, String> entry : error.entrySet()){
                description = description.replaceAll(entry.getKey(), entry.getValue());
            }
        }
        ResponseResultUtils.setResponseResult(responseResult, key, code, description);
        return responseResult;
    }
}
