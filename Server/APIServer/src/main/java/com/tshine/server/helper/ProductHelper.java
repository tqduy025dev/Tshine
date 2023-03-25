package com.tshine.server.helper;

import com.tshine.common.dto.base.Response;
import com.tshine.common.dto.base.ResponseData;
import com.tshine.common.dto.base.ResponseResult;
import com.tshine.common.dto.product.ProductRequest;
import com.tshine.common.dto.product.ProductResponse;
import com.tshine.common.entities.product.Category;
import com.tshine.common.entities.product.Product;
import com.tshine.common.entities.store.Discount;
import com.tshine.common.utils.AppUtils;
import com.tshine.common.utils.ResponseResultUtils;
import com.tshine.server.apiserver.service.CategoryService;
import com.tshine.server.apiserver.service.DiscountService;
import com.tshine.server.apiserver.service.ProductService;
import com.tshine.common.utils.PagingUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.tshine.common.constants.AppConstants.FAIL_CODE;
import static com.tshine.common.constants.AppConstants.SUCC_CODE;
import static com.tshine.common.constants.MessageConstants.*;
import static com.tshine.common.constants.AppConstants.FAIL_CODE;
import static com.tshine.common.constants.AppConstants.SUCC_CODE;

@Service
public class ProductHelper {
    private final Logger logger = LoggerFactory.getLogger(ProductHelper.class);
    private final Response response = new Response();

    private final ProductService productService;
    private final CategoryService categoryService;
    private final DiscountService discountService;

    public ProductHelper(ProductService productService, CategoryService categoryService, DiscountService discountService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.discountService = discountService;
    }


    public Response createProduct(ProductRequest productRequest){
        ResponseResult responseResult;
        ResponseData responseData = new ResponseData();
        try {
            List<Category> categories = categoryService.findCategoryByIds(productRequest.getCategories());
            String discountId = productRequest.getDiscount();
            Discount discount;
            if(StringUtils.isNotEmpty(discountId)){
                discount = discountService.findDiscountById(discountId);
            }else {
                discount = null;
            }
            Product product = productService.createProduct(productRequest, categories, discount);
            Object result = AppUtils.converToDTO(product, ProductResponse.class);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_SUCC, SUCC_CODE);
            responseData.setData(result);
        }catch (Exception e){
            logger.error("******UserHelper Error createEmployee()******", e);
            responseResult = ResponseResultUtils.getResponseResult(CREATE_FAIL, FAIL_CODE);
            responseData = null;
        }
        response.setResponse(responseData);
        response.setResult(responseResult);
        return response;
    }

    public Response findProduct(Map<String, String> map, Pageable pageable ){
        ResponseResult responseResult;
        ResponseData responseData = new ResponseData();
        try {
            String categoryId = map.get("categoryId");
            Page<Product> products = productService.findAllProduct(pageable);

            if(StringUtils.isNotEmpty(categoryId)){
                products = productService.findProductByCategory(categoryId, pageable);
            }

            Object result = AppUtils.converToDTO(products.getContent(), ProductResponse[].class);
            responseResult = ResponseResultUtils.getResponseResult(SUCC_KEY, SUCC_CODE);
            responseData.setData(result);
            PagingUtils.setDataResponse(responseData, products);
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
