package com.tshine.server.apiserver.service.impl;

import com.tshine.server.apiserver.entities.role.Role;
import com.tshine.server.apiserver.entities.user.UserInfo;
import com.tshine.server.apiserver.repository.UserRepositories;
import com.tshine.server.apiserver.service.AmazonClientService;
import com.tshine.server.apiserver.service.UserService;
import com.tshine.server.common.dto.user.UserRequest;
import com.tshine.server.common.factory.KeyGenarator;
import com.tshine.server.common.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepositories userRepositories;
    private final AmazonClientService amazonClientService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(@Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserServiceImpl(UserRepositories userRepositories, AmazonClientService amazonClientService) {
        this.userRepositories = userRepositories;
        this.amazonClientService = amazonClientService;
    }

    @Override
    public UserInfo createUser(UserRequest request,Role role) throws IOException {
        String url = amazonClientService.uploadFileToS3(request.getImage());
        UserInfo userInfo = (UserInfo) AppUtils.converToEntities(request, UserInfo.class);
        String password = KeyGenarator.getDefaultPassword(passwordEncoder);
        userInfo.setPassword(password);
        userInfo.setOldPassword(password);
        userInfo.getImage().setUrl(url);
        userInfo.setRole(role);
        return userRepositories.save(userInfo);
    }

    @Override
    public UserInfo findUserByUserName(String username) {
        return userRepositories.findUserInfoByUsername(username);
    }

    @Override
    public Page<UserInfo> findUser(Map<String, String> map, Pageable pageable) {
        return userRepositories.findAll(pageable);
    }


}
