package com.tshine.server.controller.permission;

import com.tshine.server.common.dto.base.Response;
import com.tshine.server.common.dto.user.PermissionRequest;
import com.tshine.server.common.dto.user.RoleRequest;
import com.tshine.server.helper.PermissionHelper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/acceptance")
public class PermissionController {
    private final PermissionHelper helper;


    public PermissionController(PermissionHelper permissionHelper) {
        this.helper = permissionHelper;
    }

    @GetMapping( "/permission")
    public ResponseEntity<?> findPermission(@RequestParam Map<String, String> map,
                                            @RequestParam(defaultValue = "0") Integer pageNo,
                                            @RequestParam(defaultValue = "20") Integer pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Response response = helper.findRolePermission("permission", map, pageable);
        int status = response.getResult().getHttpStatus();
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping("/role")
    public ResponseEntity<?> findRole(@RequestParam Map<String, String> map,
                                      @RequestParam(defaultValue = "0") Integer pageNo,
                                      @RequestParam(defaultValue = "20") Integer pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Response response = helper.findRolePermission( "role", map, pageable);
        int status = response.getResult().getHttpStatus();
        return ResponseEntity.status(status).body(response);
    }


    @PostMapping("/fixed-role")
    public ResponseEntity<?> createRole(@RequestBody RoleRequest roleRequest){
        Response response = helper.createRole(roleRequest);
        int status = response.getResult().getHttpStatus();
        return ResponseEntity.status(status).body(response);
    }
    @PostMapping("/fixed-permission")
    public ResponseEntity<?> createPermission(@RequestBody PermissionRequest permissionRequest){
        Response response = helper.createPermission(permissionRequest);
        int status = response.getResult().getHttpStatus();
        return ResponseEntity.status(status).body(response);
    }






}
