package com.tshine.server.helper;

import com.tshine.server.apiserver.entities.product.Category;
import com.tshine.server.apiserver.entities.role.Role;
import com.tshine.server.apiserver.entities.user.UserInfo;
import com.tshine.server.apiserver.service.CategoryService;
import com.tshine.server.common.dto.base.Response;
import com.tshine.server.common.dto.base.ResponseData;
import com.tshine.server.common.dto.base.ResponseResult;
import com.tshine.server.common.dto.product.CategoryRequest;
import com.tshine.server.common.dto.product.CategoryResponse;
import com.tshine.server.common.dto.user.UserResponse;
import com.tshine.server.common.utils.AppUtils;
import com.tshine.server.common.utils.PagingUtils;
import com.tshine.server.common.utils.ResponseResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.tshine.server.common.constants.AppConstants.CODE_FAIL;
import static com.tshine.server.common.constants.AppConstants.CODE_SUCC;
import static com.tshine.server.common.constants.MessageConstants.*;

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
            Category category = categoryService.createCategory(categoryRequest);
            Object result = AppUtils.converToDTO(category, CategoryRequest.class);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_SUCC, CODE_SUCC);
            responseData.setData(result);
        }catch (Exception e){
            logger.error("******UserHelper Error createEmployee()******", e);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_FAIL, CODE_FAIL);
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
            Page<Category> categorys = categoryService.findAllCategory(pageable);
            Object result = AppUtils.converToDTO(categorys.getContent(), CategoryResponse[].class);
            responseResult = ResponseResultUtils.getResponseResult(KEY_SUCC, CODE_SUCC);

            if(isPaging){
                PagingUtils.setDataResponse(responseData, categorys);
            }
            responseData.setData(result);
        }catch (Exception e){
            logger.error("******UserHelper Error createEmployee()******", e);
            responseResult = ResponseResultUtils.getResponseResult(KEY_FAIL, CODE_FAIL);
            responseData = null;
        }
        response.setResponse(responseData);
        response.setResult(responseResult);
        return response;
    }


}
