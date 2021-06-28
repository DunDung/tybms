package com.tybms.product.service;

import com.tybms.product.entity.Product;
import com.tybms.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Transactional
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Transactional
    public void increaseViewCount(Map<Long, Long> viewCountToIds) {
        viewCountToIds.entrySet()
                .stream()
                .forEach(viewCountEntry -> this.productRepository
                        .updateViewCount(viewCountEntry.getKey(), viewCountEntry.getValue()));
    }

    @Transactional
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }

}
