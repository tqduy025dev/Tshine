package com.tshine.service.repository;

import com.tshine.common.entities.system.SystemFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemFileRepositories extends JpaRepository<SystemFile, String> {
}
