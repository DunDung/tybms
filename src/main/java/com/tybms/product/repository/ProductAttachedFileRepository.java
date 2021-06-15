package com.tybms.product.repository;

import com.tybms.product.entity.ProductAttachedFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttachedFileRepository extends JpaRepository<ProductAttachedFile, Long> {
}
