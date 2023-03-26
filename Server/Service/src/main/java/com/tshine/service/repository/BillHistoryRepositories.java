package com.tshine.service.repository;


import com.tshine.common.entities.bill.BillPaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillHistoryRepositories extends JpaRepository<BillPaymentHistory, String> {
}
