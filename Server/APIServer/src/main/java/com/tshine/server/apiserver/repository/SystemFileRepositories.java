package com.tshine.server.apiserver.repository;

import com.tshine.common.entities.system.SystemFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemFileRepositories extends JpaRepository<SystemFile, String> {
}
