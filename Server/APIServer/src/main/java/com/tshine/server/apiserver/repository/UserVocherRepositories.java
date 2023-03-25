package com.tshine.server.apiserver.repository;

import com.tshine.common.entities.user.UserVocher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVocherRepositories extends JpaRepository<UserVocher, String> {
}
