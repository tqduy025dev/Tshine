package com.tshine.server.apiserver.service;

import com.tshine.server.apiserver.entities.user.UserInfo;
import com.tshine.server.common.dto.user.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.Map;

public interface UserService {
    UserInfo createUser(UserRequest request) throws IOException;
    UserInfo findUserByUserName(String username);
    Page<UserInfo> findUser(Map<String,String> map, Pageable pageable);
}
