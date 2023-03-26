package com.tshine.service.repository;

import com.tshine.common.entities.store.Vocher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocherRepositories extends JpaRepository<Vocher, String> {
}
