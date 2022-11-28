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
            case CODE_FAIL:
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
        return responseResult;
    }


}
