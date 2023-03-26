package com.tshine.service.repository;


import com.tshine.common.entities.store.StoreBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreBranchRepositories extends JpaRepository<StoreBranch, String> {
}
