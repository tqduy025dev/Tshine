package com.tshine.service.service;

import com.tshine.common.entities.user.UserInfo;
import com.tshine.common.dto.user.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.Map;

public interface UserService {
    UserInfo createUser(UserRequest request) throws IOException;
    UserInfo findUserByUserName(String username);
    Page<UserInfo> findUser(Map<String,String> map, Pageable pageable);
}
