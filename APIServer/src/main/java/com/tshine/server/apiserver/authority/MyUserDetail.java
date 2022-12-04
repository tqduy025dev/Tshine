package com.tshine.server.apiserver.authority;


import com.tshine.server.apiserver.entities.role.Permission;
import com.tshine.server.apiserver.entities.user.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetail implements UserDetails {
    private static final Logger log = LoggerFactory.getLogger(MyUserDetail.class);


    private UserInfo userInfo;

    public MyUserDetail(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        try {
            String role = userInfo.getRole().getCode();
            for (Permission permission : userInfo.getRole().getPermissions()){
                String role_permission = role + permission.getCode();
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role_permission);
                authorities.add(simpleGrantedAuthority);
            }
        }catch (Exception e){
            log.error( "**MyUserDetail getAuthorities() Error**", e);
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
