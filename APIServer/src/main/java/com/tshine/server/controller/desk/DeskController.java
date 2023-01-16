package com.tshine.server.controller.desk;

import com.tshine.server.common.dto.base.Response;
import com.tshine.server.common.dto.system.DeskRequest;
import com.tshine.server.helper.DeskHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/desk")
public class DeskController {
    private final DeskHelper helper;

    public DeskController(DeskHelper helper) {
        this.helper = helper;
    }

    @PostMapping("/fixed-desk")
    public ResponseEntity<?> createDesk(@RequestBody DeskRequest deskRequest) {
        Response response = helper.createDesk(deskRequest);
        int status = response.getResult().getHttpStatus();
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping("/educed-desk/{id}")
    public ResponseEntity<?> findDeskById(@PathVariable String id) {
        Response response = helper.findDeskById(id);
        int status = response.getResult().getHttpStatus();
        return ResponseEntity.status(status).body(response);
    }


}
