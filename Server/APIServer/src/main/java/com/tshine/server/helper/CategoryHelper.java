package com.tshine.server.helper;

import com.tshine.common.entities.product.Category;
import com.tshine.server.apiserver.service.CategoryService;
import com.tshine.common.dto.base.BaseData;
import com.tshine.common.dto.base.Response;
import com.tshine.common.dto.base.ResponseData;
import com.tshine.common.dto.base.ResponseResult;
import com.tshine.common.dto.product.CategoryRequest;
import com.tshine.common.dto.product.CategoryResponse;
import com.tshine.common.utils.AppUtils;
import com.tshine.common.utils.PagingUtils;
import com.tshine.common.utils.ResponseResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.tshine.common.constants.AppConstants.FAIL_CODE;
import static com.tshine.common.constants.AppConstants.SUCC_CODE;
import static com.tshine.common.constants.MessageConstants.*;

@Service
public class CategoryHelper {
    private final Logger logger = LoggerFactory.getLogger(CategoryHelper.class);
    private final Response response = new Response();

    private final CategoryService categoryService;

    public CategoryHelper(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Response createCategory(CategoryRequest categoryRequest){
        ResponseResult responseResult;
        ResponseData responseData = new ResponseData();
        try {
            BaseData category = categoryService.createCategory(categoryRequest);
            if(category.isNotError()){
                Object result = AppUtils.converToDTO(category.getResult(), CategoryRequest.class);
                responseResult = ResponseResultUtils.getResponseResult(CREATE_SUCC, SUCC_CODE);
                responseData.setData(result);
            }else {
                responseResult = ResponseResultUtils.getResponseResult(category.getStatus(), category.getError());
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

    public Response findCategory(Map<String, String> map, Pageable pageable, boolean isPaging){
        ResponseResult responseResult;
        ResponseData responseData = new ResponseData();
        try {
            Page<Category> categorys = categoryService.findCategory(pageable);
            Object result = AppUtils.converToDTO(categorys.getContent(), CategoryResponse[].class);
            responseResult = ResponseResultUtils.getResponseResult(SUCC_KEY, SUCC_CODE);

            if(isPaging){
                PagingUtils.setDataResponse(responseData, categorys);
            }
            responseData.setData(result);
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
