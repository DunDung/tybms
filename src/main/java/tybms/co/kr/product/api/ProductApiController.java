package tybms.co.kr.product.api;

import tybms.co.kr.product.dto.ProductResponse;
import tybms.co.kr.product.dto.ProductUpdateRequest;
import tybms.co.kr.product.entity.Product;
import tybms.co.kr.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductApiController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(this.productService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid Product product) {
        Product savedProduct = this.productService.save(product);
        return ResponseEntity.created(URI.create("/" + savedProduct.getId())).build();
    }

    @PatchMapping
    public ResponseEntity<Void> increaseViewCount(@RequestBody Map<Long, Long> viewCountToIds) {
        this.productService.increaseViewCount(viewCountToIds);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody ProductUpdateRequest productUpdateRequest) {
        this.productService.update(productUpdateRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}