package com.tshine.server.apiserver.service;

import com.tshine.server.apiserver.entities.store.Discount;

public interface DiscountService {
    Discount findDiscountById(String id);
}
