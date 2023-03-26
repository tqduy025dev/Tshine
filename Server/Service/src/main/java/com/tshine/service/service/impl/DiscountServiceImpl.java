package com.tshine.service.service.impl;

import com.tshine.common.entities.store.Discount;
import com.tshine.service.repository.DiscountRepositories;
import com.tshine.service.service.DiscountService;
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
