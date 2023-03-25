package com.tshine.server.apiserver.repository;


import com.tshine.common.entities.store.StoreBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreBranchRepositories extends JpaRepository<StoreBranch, String> {
}
