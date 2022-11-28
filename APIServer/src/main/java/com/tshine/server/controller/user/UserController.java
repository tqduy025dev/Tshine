package com.tshine.server.controller.user;

import com.tshine.server.common.dto.base.Response;
import com.tshine.server.controller.helper.UserHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserHelper helper;

    public UserController(UserHelper helper) {
        this.helper = helper;
    }


    @GetMapping("/authorize-user")
    public ResponseEntity<?> getEmployeeFromJwt(Authentication authentication) {
        Response response = helper.authorizeUser(authentication);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
