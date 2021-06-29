package com.tybms.material.repository;

import com.tybms.material.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    @Modifying
    @Query("UPDATE Material set viewCount = viewCount + :expectedViewCount where id = :id")
    void updateViewCount(@Param("id") Long id, @Param("expectedViewCount") Long expectedViewCount);
}
