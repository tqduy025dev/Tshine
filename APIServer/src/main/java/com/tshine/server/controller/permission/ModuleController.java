package com.tshine.server.controller.permission;

import com.tshine.server.common.dto.base.Response;
import com.tshine.server.common.dto.user.ModuleRequest;
import com.tshine.server.helper.ModuleHelper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/acceptance")
public class ModuleController {
    private final ModuleHelper helper;

    public ModuleController(ModuleHelper helper) {
        this.helper = helper;
    }

    @GetMapping("/module")
    public ResponseEntity<?> findModule(@RequestParam Map<String, String> map,
                                      @RequestParam(defaultValue = "0") Integer pageNo,
                                      @RequestParam(defaultValue = "20") Integer pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Response response = helper.findAllModule(pageable);
        int status = response.getResult().getHttpStatus();
        return ResponseEntity.status(status).body(response);
    }

    @PostMapping("/fixed-module")
    public ResponseEntity<?> createRole(@ModelAttribute ModuleRequest moduleRequest){
        Response response = helper.createModule(moduleRequest);
        int status = response.getResult().getHttpStatus();
        return ResponseEntity.status(status).body(response);
    }
}
