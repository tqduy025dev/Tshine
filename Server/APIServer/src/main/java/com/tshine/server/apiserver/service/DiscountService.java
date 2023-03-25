package com.tshine.server.apiserver.service;

import com.tshine.common.entities.store.Discount;

public interface DiscountService {
    Discount findDiscountById(String id);
}
