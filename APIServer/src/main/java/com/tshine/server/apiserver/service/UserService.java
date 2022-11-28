package com.tshine.server.apiserver.service;

import com.tshine.server.apiserver.entities.user.UserInfo;
import com.tshine.server.common.dto.user.UserRequest;

public interface UserService {
    UserInfo createUser(UserRequest request);
    UserInfo findUserByUserName(String username);
}
