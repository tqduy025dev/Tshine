package com.tshine.server.helper;

import com.tshine.service.service.SystemDeskService;
import com.tshine.common.dto.base.BaseData;
import com.tshine.common.dto.base.Response;
import com.tshine.common.dto.base.ResponseData;
import com.tshine.common.dto.base.ResponseResult;
import com.tshine.common.dto.system.DeskRequest;
import com.tshine.common.utils.AppUtils;
import com.tshine.common.utils.ResponseResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.tshine.common.constants.AppConstants.FAIL_CODE;
import static com.tshine.common.constants.AppConstants.SUCC_CODE;
import static com.tshine.common.constants.MessageConstants.*;

@Service
public class DeskHelper {
    private final Logger logger = LoggerFactory.getLogger(CategoryHelper.class);
    private final Response response = new Response();

    private final SystemDeskService systemDeskService;

    public DeskHelper(SystemDeskService systemDeskService) {
        this.systemDeskService = systemDeskService;
    }

    public Response createDesk(DeskRequest deskRequest){
        ResponseResult responseResult;
        ResponseData responseData = new ResponseData();
        try {
            BaseData baseData = systemDeskService.createDesk(deskRequest);
            if(baseData.isNotError()){
                Object result = AppUtils.converToDTO(baseData.getResult(), DeskRequest.class);
                responseResult = ResponseResultUtils.getResponseResult(CREATE_SUCC, SUCC_CODE);
                responseData.setData(result);
            }else {
                responseResult = ResponseResultUtils.getResponseResult(baseData.getStatus(), baseData.getError());
            }
        }catch (Exception e){
            logger.error("******UserHelper Error createEmployee()******", e);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_FAIL, FAIL_CODE);
            responseData = null;
        }
        response.setResponse(responseData);
        response.setResult(responseResult);
        return response;
    }

    public Response findDeskById(String id){
        ResponseResult responseResult;
        ResponseData responseData = new ResponseData();
        try {
            BaseData baseData = systemDeskService.findDeskById(id);
            if(baseData.isNotError()){
                Object result = AppUtils.converToDTO(baseData.getResult(), DeskRequest.class);
                responseResult = ResponseResultUtils.getResponseResult(SUCC_KEY, SUCC_CODE);
                responseData.setData(result);
            }else {
                responseResult = ResponseResultUtils.getResponseResult(baseData.getStatus(), baseData.getError());
            }
        }catch (Exception e){
            logger.error("******UserHelper Error createEmployee()******", e);
            responseResult = ResponseResultUtils.getResponseResult(FAIL_KEY, FAIL_CODE);
            responseData = null;
        }
        response.setResponse(responseData);
        response.setResult(responseResult);
        return response;
    }


}
