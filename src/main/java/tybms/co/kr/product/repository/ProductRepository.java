package tybms.co.kr.product.repository;

import tybms.co.kr.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Query("UPDATE Product set viewCount = viewCount + :expectedViewCount where id = :id")
    void updateViewCount(@Param("id") Long id, @Param("expectedViewCount") Long expectedViewCount);
}
