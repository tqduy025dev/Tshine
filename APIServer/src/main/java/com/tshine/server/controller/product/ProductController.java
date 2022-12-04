package com.tshine.server.controller.product;

import com.tshine.server.common.dto.base.Response;
import com.tshine.server.common.dto.product.ProductRequest;
import com.tshine.server.helper.ProductHelper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductHelper helper;

    public ProductController(ProductHelper helper) {
        this.helper = helper;
    }

    @PostMapping("/fixed-product")
    public ResponseEntity<?> createProduct(@ModelAttribute ProductRequest productRequest) {
        Response response = helper.createProduct(productRequest);
        int status = response.getResult().getHttpStatus();
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping("/educed-product")
    public ResponseEntity<?> findProduct(@RequestParam Map<String, String> map,
                                         @RequestParam(defaultValue = "0") Integer pageNo,
                                         @RequestParam(defaultValue = "20") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Response response = helper.findProduct(map, pageable);
        int status = response.getResult().getHttpStatus();
        return ResponseEntity.status(status).body(response);
    }


}
