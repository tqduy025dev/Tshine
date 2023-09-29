package com.tshine.server.controller.user;

import com.tshine.common.dto.base.ResponseResult;
import com.tshine.common.utils.ResponseResultUtils;
import com.tshine.service.service.UserService;
import com.tshine.common.dto.authorize.LoginRequest;
import com.tshine.common.dto.base.Response;
import com.tshine.server.helper.LoginHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.tshine.common.constants.AppConstants.FAIL_CODE;
import static com.tshine.common.constants.AppConstants.SUCC_CODE;
import static com.tshine.common.constants.MessageConstants.CREATE_FAIL;
import static com.tshine.common.constants.MessageConstants.HEALTHY_KEY;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final LoginHelper loginHelper;
    @Autowired
    private UserService userService;


    public AuthController(LoginHelper loginHelper) {
        this.loginHelper = loginHelper;
    }

    @GetMapping("/health-check")
    public ResponseEntity<?> healthCheck() {
        Response response = new Response();
        ResponseResult result = ResponseResultUtils.getResponseResult(HEALTHY_KEY, SUCC_CODE);
        response.setResult(result);
        return ResponseEntity.status(HttpStatus.OK).body(response);
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
