package com.tshine.server.apiserver.repository;


import com.tshine.common.entities.bill.BillPaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillInfoRepositories extends JpaRepository<BillPaymentInfo, String> {
}
