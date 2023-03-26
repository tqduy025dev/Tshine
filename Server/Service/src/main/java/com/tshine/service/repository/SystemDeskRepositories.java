package com.tshine.service.repository;

import com.tshine.common.entities.system.SystemDesk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemDeskRepositories extends JpaRepository<SystemDesk, String> {
}
