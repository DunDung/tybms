package co.kr.tybms.material.repository;

import co.kr.tybms.material.entity.MaterialAttachedFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialAttachedFileRepository extends JpaRepository<MaterialAttachedFile, Long> {

    List<MaterialAttachedFile> findByMaterialId(Long id);

    void deleteByName(String name);
}
