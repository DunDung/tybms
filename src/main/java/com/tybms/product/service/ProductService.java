package com.tybms.product.service;

import com.tybms.file.FileService;
import com.tybms.product.dto.ProductResponse;
import com.tybms.product.dto.ProductUpdateRequest;
import com.tybms.product.entity.Product;
import com.tybms.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final FileService fileService;

    @Transactional
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> findAll() {
        return this.productRepository.findAll().stream()
                .map(ProductResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public void increaseViewCount(Map<Long, Long> viewCountToIds) {
        viewCountToIds.forEach(this.productRepository::updateViewCount);
    }

    @Transactional
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }

    @Transactional
    public void update(ProductUpdateRequest productUpdateRequest) {
        Product productById = this.productRepository.findById(productUpdateRequest.getId())
                .orElseThrow(NoSuchElementException::new);
        if (productById.isNotMatchAttachedFile(productUpdateRequest.getAttachedFile())) {
            fileService.deleteFile(productById.getAttachedFile());
        }
        productById.update(productUpdateRequest);
    }
}
