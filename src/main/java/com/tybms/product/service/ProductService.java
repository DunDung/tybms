package com.tybms.product.service;

import com.tybms.product.dto.ProductCreateRequest;
import com.tybms.product.dto.ProductResponse;
import com.tybms.product.entity.Product;
import com.tybms.product.entity.ProductAttachedFile;
import com.tybms.product.repository.ProductAttachedFileRepository;
import com.tybms.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductAttachedFileRepository productAttachedFileRepository;

    @Transactional
    public Product save(ProductCreateRequest productCreateRequest) {
        Product savedProduct = this.productRepository.save(productCreateRequest.toProduct());
        List<ProductAttachedFile> productAttachedFiles = productCreateRequest.toProductAttachedFiles();
        productAttachedFiles.forEach(noticeAttachedFile -> noticeAttachedFile.setProduct(savedProduct));
        this.productAttachedFileRepository.saveAll(productAttachedFiles);
        return savedProduct;
    }

    @Transactional
    public List<ProductResponse> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductResponse::from)
                .collect(Collectors.toList());
    }

}
