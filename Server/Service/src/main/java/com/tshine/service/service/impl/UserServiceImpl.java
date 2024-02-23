package com.tshine.service.service.impl;

import com.tshine.common.constants.AppConstants;
import com.tshine.common.entities.role.Role;
import com.tshine.common.entities.user.UserInfo;
import com.tshine.common.utils.TimeUtils;
import com.tshine.service.repository.UserRepositories;
import com.tshine.service.service.AmazonClientService;
import com.tshine.service.service.RoleService;
import com.tshine.service.service.SystemFileService;
import com.tshine.service.service.UserService;
import com.tshine.common.dto.user.UserRequest;
import com.tshine.common.factory.KeyGenarator;
import com.tshine.common.utils.AppUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepositories userRepositories;
    private final AmazonClientService amazonClientService;
    private final RoleService roleService;
    private final SystemFileService systemFileService;
    private PasswordEncoder passwordEncoder;
    @Value("${directory.location}")
    private String pathDirectory;
    @Autowired
    public void setPasswordEncoder(@Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserServiceImpl(UserRepositories userRepositories, AmazonClientService amazonClientService, RoleService roleService, SystemFileService systemFileService) {
        this.userRepositories = userRepositories;
        this.amazonClientService = amazonClientService;
        this.roleService = roleService;
        this.systemFileService = systemFileService;
    }

    @Override
    public UserInfo createUser(UserRequest request) throws IOException {
        logger.info("******Begin UserServiceImpl createUser()******");
        Role role;
        if(StringUtils.isNotEmpty(request.getRole())){
            role = roleService.findRoleById(request.getRole());
        }else {
            role = roleService.findRoleByCode(AppConstants.DEFAULT_ROLE);
        }
//        String url = amazonClientService.uploadFileToS3(request.getImage());
        String url = systemFileService.saveFileToStorage(request.getImage(), pathDirectory, "user") ;
        UserInfo userInfo = (UserInfo) AppUtils.converToEntities(request, UserInfo.class);
        String password = KeyGenarator.getDefaultPassword(passwordEncoder);
        userInfo.setPassword(password);
        userInfo.setOldPassword(password);
        userInfo.getImage().setUrl(url);
        userInfo.setRole(role);
        userInfo.setCreatedTime(TimeUtils.getTimestampNow());
        logger.info("******UserServiceImpl createUser() with url image=" + url);
        logger.info("******End UserServiceImpl createUser()******");
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
