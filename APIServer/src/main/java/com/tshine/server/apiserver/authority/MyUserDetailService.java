package com.tshine.server.apiserver.authority;


import com.tshine.server.apiserver.entities.user.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(MyUserDetailService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        if(userInfo != null){
            return new MyUserDetail(userInfo);
        }else{
            log.debug("User not found with emailId: " + username);
            throw new UsernameNotFoundException("User not found with emailId: " + username);
        }
    }
}
