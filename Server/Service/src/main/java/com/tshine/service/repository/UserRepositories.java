package com.tshine.service.repository;

import com.tshine.common.entities.user.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<UserInfo, String> {
    UserInfo findUserInfoByUsername(String username);
}
