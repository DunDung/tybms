package com.tybms.material.repository;

import com.tybms.material.entity.MaterialAttachedFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialAttachedFileRepository extends JpaRepository<MaterialAttachedFile, Long> {

    List<MaterialAttachedFile> findByMaterialId(Long id);

    void deleteByName(String name);
}
