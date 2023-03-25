package com.tshine.server.apiserver.repository;


import com.tshine.common.entities.store.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepositories extends JpaRepository<Discount, String> {
}
