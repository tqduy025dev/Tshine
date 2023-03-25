package com.tshine.server.apiserver.repository;

import com.tshine.common.entities.store.Vocher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VocherRepositories extends JpaRepository<Vocher, String> {
}
