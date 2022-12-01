package com.tshine.server.controller.user;

import com.tshine.server.common.dto.base.Response;
import com.tshine.server.common.dto.user.UserRequest;
import com.tshine.server.helper.UserHelper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserHelper helper;

    public UserController(UserHelper helper) {
        this.helper = helper;
    }

    @PostMapping("/fixed-user")
    public ResponseEntity<?> createEmployee(@ModelAttribute UserRequest userRequest) {
        Response response = helper.createEmployee(userRequest);
        int status = response.getResult().getHttpStatus();
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping("/authen-user")
    public ResponseEntity<?> getEmployeeFromJwt(Authentication authentication) {
        Response response = helper.authorizeUser(authentication);
        int status = response.getResult().getHttpStatus();
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping("/educed-user")
    public ResponseEntity<?> findEmployee(@RequestParam Map<String, String> map,
                                          @RequestParam(defaultValue = "0") Integer pageNo,
                                          @RequestParam(defaultValue = "20") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Response response = helper.findUser(map, pageable);
        int status = response.getResult().getHttpStatus();
        return ResponseEntity.status(status).body(response);
    }
}
