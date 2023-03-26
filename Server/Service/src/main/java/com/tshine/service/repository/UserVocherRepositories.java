package com.tshine.service.repository;

import com.tshine.common.entities.user.UserVocher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVocherRepositories extends JpaRepository<UserVocher, String> {
}
