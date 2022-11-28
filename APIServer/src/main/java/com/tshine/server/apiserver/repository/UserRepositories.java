package com.tshine.server.apiserver.repository;

import com.tshine.server.apiserver.entities.user.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<UserInfo, String> {
    UserInfo findUserInfoByUsername(String username);
}
