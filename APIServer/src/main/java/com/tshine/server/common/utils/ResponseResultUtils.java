package com.tshine.server.common.utils;


import com.tshine.server.common.dto.base.ResponseResult;

import static com.tshine.server.common.constants.AppConstants.*;

public class ResponseResultUtils {

    public static ResponseResult getResponseResult(String key, String code) {
        ResponseResult responseResult = new ResponseResult();
        String description = ResourceBundle.getInstance().getName(key);
        responseResult.setKey(key);
        responseResult.setCode(code);
        responseResult.setDesc(description);
        switch (code){
            case FAIL_CODE:
                responseResult.setHttpStatus(404);
                break;
            case UNAUTHORIZED_CODE:
                responseResult.setHttpStatus(401);
                break;
            case BAD_REQUEST_CODE:
                responseResult.setHttpStatus(400);
                break;
            case CONFLICT_CODE:
                responseResult.setHttpStatus(409);
                break;
            case CREATED_CODE:
                responseResult.setHttpStatus(201);
                break;
            case ACCEPTED_CODE:
                responseResult.setHttpStatus(202);
                break;
            default:
                responseResult.setHttpStatus(200);
        }
        return responseResult;
    }


}
