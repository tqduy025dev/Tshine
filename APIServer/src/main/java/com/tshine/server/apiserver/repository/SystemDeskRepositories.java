package com.tshine.server.apiserver.repository;

import com.tshine.server.apiserver.entities.system.SystemDesk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemDeskRepositories extends JpaRepository<SystemDesk, String> {
}
