package com.tshine.server.controller.product;

import com.tshine.server.common.dto.base.Response;
import com.tshine.server.common.dto.product.CategoryRequest;
import com.tshine.server.helper.CategoryHelper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryHelper helper;

    public CategoryController(CategoryHelper helper) {
        this.helper = helper;
    }

    @PostMapping("/fixed-category")
    public ResponseEntity<?> createEmployee(@RequestBody CategoryRequest categoryRequest) {
        Response response = helper.createCategory(categoryRequest);
        int status = response.getResult().getHttpStatus();
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping("/educed-category")
    public ResponseEntity<?> findCategory(@RequestParam Map<String, String> map,
                                          @RequestParam(defaultValue = "true") boolean isPaging,
                                          @RequestParam(defaultValue = "0") Integer pageNo,
                                          @RequestParam(defaultValue = "20") Integer pageSize) {
        Pageable pageable = isPaging ? PageRequest.of(pageNo, pageSize) : Pageable.unpaged();
        Response response = helper.findCategory(map, pageable, isPaging);
        int status = response.getResult().getHttpStatus();
        return ResponseEntity.status(status).body(response);
    }
}
