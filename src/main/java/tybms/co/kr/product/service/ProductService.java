package tybms.co.kr.product.service;

import tybms.co.kr.file.FileService;
import tybms.co.kr.product.repository.ProductRepository;
import tybms.co.kr.product.dto.ProductResponse;
import tybms.co.kr.product.dto.ProductUpdateRequest;
import tybms.co.kr.product.entity.Product;
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