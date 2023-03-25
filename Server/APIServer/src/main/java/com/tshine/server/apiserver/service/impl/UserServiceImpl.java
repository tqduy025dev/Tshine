package com.tshine.server.apiserver.service.impl;

import com.tshine.common.entities.role.Role;
import com.tshine.common.entities.user.UserInfo;
import com.tshine.common.entities.user.UserInfo;
import com.tshine.server.apiserver.repository.UserRepositories;
import com.tshine.server.apiserver.service.AmazonClientService;
import com.tshine.server.apiserver.service.RoleService;
import com.tshine.server.apiserver.service.UserService;
import com.tshine.common.dto.user.UserRequest;
import com.tshine.common.factory.KeyGenarator;
import com.tshine.common.utils.AppUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

import static com.tshine.common.constants.AppConstants.DEFAULT_ROLE;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepositories userRepositories;
    private final AmazonClientService amazonClientService;
    private final RoleService roleService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(@Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserServiceImpl(UserRepositories userRepositories, AmazonClientService amazonClientService, RoleService roleService) {
        this.userRepositories = userRepositories;
        this.amazonClientService = amazonClientService;
        this.roleService = roleService;
    }

    @Override
    public UserInfo createUser(UserRequest request) throws IOException {
        Role role;
        if(StringUtils.isNotEmpty(request.getRole())){
            role = roleService.findRoleById(request.getRole());
        }else {
            role = roleService.findRoleByCode(DEFAULT_ROLE);
        }
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
