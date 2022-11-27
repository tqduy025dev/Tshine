package com.tshine.server.apiserver.common.utils;


import com.tshine.server.apiserver.common.dto.base.ResponseResult;

public class ResponseResultUtils {

    public static ResponseResult getResponseResult(String key, String code) {
        ResponseResult responseResult = new ResponseResult();
        String description = ResourceBundle.getInstance().getName(key);
        responseResult.setKey(key);
        responseResult.setCode(code);
        responseResult.setDesc(description);
        return responseResult;
    }


}
