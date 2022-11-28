package com.tshine.server.apiserver.authority;


import com.tshine.server.apiserver.entities.user.UserInfo;
import com.tshine.server.apiserver.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(MyUserDetailService.class);

    private final UserService userService;

    public MyUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userService.findUserByUserName(username);
        if(userInfo != null){
            return new MyUserDetail(userInfo);
        }else{
            log.debug("User not found with username: " + username);
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
