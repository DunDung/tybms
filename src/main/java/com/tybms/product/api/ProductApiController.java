package com.tybms.product.api;

import com.tybms.product.dto.ProductCreateRequest;
import com.tybms.product.dto.ProductResponse;
import com.tybms.product.entity.Product;
import com.tybms.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductApiController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        List<ProductResponse> productResponses = this.productService.findAll();
        return ResponseEntity.ok(productResponses);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid ProductCreateRequest productCreateRequest) {
        Product savedProduct = this.productService.save(productCreateRequest);
        return ResponseEntity.created(URI.create("/" + savedProduct.getId())).build();
    }

}
