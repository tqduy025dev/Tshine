package com.tshine.server.apiserver.service.impl;

import com.tshine.common.entities.store.Discount;
import com.tshine.server.apiserver.repository.DiscountRepositories;
import com.tshine.server.apiserver.service.DiscountService;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepositories discountRepositories;

    public DiscountServiceImpl(DiscountRepositories discountRepositories) {
        this.discountRepositories = discountRepositories;
    }

    @Override
    public Discount findDiscountById(String id) {
        return discountRepositories.findById(id).orElse(null);
    }
}
