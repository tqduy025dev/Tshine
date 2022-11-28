package com.tshine.server.apiserver.repository;

import com.tshine.server.apiserver.entities.store.Vocher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VocherRepositories extends JpaRepository<Vocher, String> {
}
