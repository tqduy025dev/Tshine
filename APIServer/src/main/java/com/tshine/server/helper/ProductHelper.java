package com.tshine.server.helper;

import com.tshine.server.apiserver.entities.product.Category;
import com.tshine.server.apiserver.entities.product.Product;
import com.tshine.server.apiserver.entities.store.Discount;
import com.tshine.server.apiserver.service.CategoryService;
import com.tshine.server.apiserver.service.DiscountService;
import com.tshine.server.apiserver.service.ProductService;
import com.tshine.server.common.dto.base.Response;
import com.tshine.server.common.dto.base.ResponseData;
import com.tshine.server.common.dto.base.ResponseResult;
import com.tshine.server.common.dto.product.ProductRequest;
import com.tshine.server.common.dto.product.ProductResponse;
import com.tshine.server.common.utils.AppUtils;
import com.tshine.server.common.utils.PagingUtils;
import com.tshine.server.common.utils.ResponseResultUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.tshine.server.common.constants.AppConstants.CODE_FAIL;
import static com.tshine.server.common.constants.AppConstants.CODE_SUCC;
import static com.tshine.server.common.constants.MessageConstants.*;

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
            responseResult = ResponseResultUtils.getResponseResult(KEY_SUCC, CODE_SUCC);
            responseData.setData(result);
            PagingUtils.setDataResponse(responseData, products);
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
