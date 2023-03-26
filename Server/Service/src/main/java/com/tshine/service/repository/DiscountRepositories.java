package com.tshine.service.repository;


import com.tshine.common.entities.store.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepositories extends JpaRepository<Discount, String> {
}
