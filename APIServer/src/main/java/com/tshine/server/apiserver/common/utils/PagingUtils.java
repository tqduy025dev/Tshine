package com.tshine.server.apiserver.common.utils;

import com.tshine.server.apiserver.common.dto.base.ResponseData;
import org.springframework.data.domain.Page;

public class PagingUtils {
    public static void setDataResponse(ResponseData responseData, Page<?> page){
        responseData.setPageSize(page.getSize());
        responseData.setPageNo(page.getNumber());
        responseData.setTotalPages(page.getTotalPages());
        responseData.setTotalItems(page.getNumberOfElements());
        responseData.setTotalElements(page.getTotalElements());
        responseData.setNext(page.hasNext());
        responseData.setPrev(page.hasPrevious());
    }
}
