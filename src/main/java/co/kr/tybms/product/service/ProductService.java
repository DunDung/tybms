package co.kr.tybms.product.service;

import co.kr.tybms.file.FileService;
import co.kr.tybms.product.dto.ProductResponse;
import co.kr.tybms.product.dto.ProductUpdateRequest;
import co.kr.tybms.product.entity.Product;
import co.kr.tybms.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

    @CacheEvict(cacheNames = "PRODUCTS", allEntries = true)
    @Transactional
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Cacheable(cacheNames = "PRODUCTS")
    @Transactional(readOnly = true)
    public List<ProductResponse> findAll() {
        return this.productRepository.findAll().stream()
                .map(ProductResponse::from)
                .collect(Collectors.toList());
    }

    @CacheEvict(cacheNames = "PRODUCTS", allEntries = true)
    @Transactional
    public void increaseViewCount(Map<Long, Long> viewCountToIds) {
        viewCountToIds.forEach(this.productRepository::updateViewCount);
    }

    @CacheEvict(cacheNames = "PRODUCTS", allEntries = true)
    @Transactional
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }

    @CacheEvict(cacheNames = "PRODUCTS", allEntries = true)
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