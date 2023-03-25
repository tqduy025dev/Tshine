package com.tshine.server.controller.user;

import com.tshine.server.apiserver.service.UserService;
import com.tshine.common.dto.authorize.LoginRequest;
import com.tshine.common.dto.base.Response;
import com.tshine.server.helper.LoginHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final LoginHelper loginHelper;
    @Autowired
    private UserService userService;


    public AuthController(LoginHelper loginHelper) {
        this.loginHelper = loginHelper;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
//        UserRequest userRequest = new UserRequest();
//        userRequest.setFirstName("Duy");
//        userRequest.setLastName("Tran");
//        userRequest.setUserName("duytq");
//        userRequest.setAddress("Quận 9, Tp HCM");
//        userRequest.setEmail("admin@gmail.com");
//        userRequest.setDateOfBirth("05/02/2000");
//        userRequest.setGender("M");
//        userRequest.setPhone("0987654321");
//        userService.createUser(userRequest);


        Response response = loginHelper.authorize(loginRequest);
        int status = response.getResult().getHttpStatus();
        return ResponseEntity.status(status).body(response);
    }
}
