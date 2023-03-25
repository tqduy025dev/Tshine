package com.tshine.server.apiserver.repository;


import com.tshine.common.entities.bill.BillPaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillHistoryRepositories extends JpaRepository<BillPaymentHistory, String> {
}
