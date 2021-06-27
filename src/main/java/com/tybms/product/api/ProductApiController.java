package com.tybms.product.api;

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
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(this.productService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid Product product) {
        Product savedProduct = this.productService.save(product);
        return ResponseEntity.created(URI.create("/" + savedProduct.getId())).build();
    }

}
