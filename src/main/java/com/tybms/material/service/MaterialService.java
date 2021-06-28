package com.tybms.material.service;

import com.tybms.material.dto.MaterialCreateRequest;
import com.tybms.material.dto.MaterialResponse;
import com.tybms.material.entity.Material;
import com.tybms.material.entity.MaterialAttachedFile;
import com.tybms.material.repository.MaterialAttachedFileRepository;
import com.tybms.material.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MaterialService {

    private final MaterialRepository materialRepository;
    private final MaterialAttachedFileRepository materialAttachedFileRepository;

    @Transactional
    public Material save(MaterialCreateRequest materialCreateRequest) {
        Material savedMaterial = this.materialRepository.save(materialCreateRequest.toMaterial());
        List<MaterialAttachedFile> materialAttachedFiles = materialCreateRequest.toMaterialAttachedFiles();
        materialAttachedFiles.forEach(materialAttachedFile -> materialAttachedFile.setMaterial(savedMaterial));
        this.materialAttachedFileRepository.saveAll(materialAttachedFiles);
        return savedMaterial;
    }

    @Transactional
    public List<MaterialResponse> findAll() {
        List<Material> materials = this.materialRepository.findAll();
        return materials.stream()
                .map(MaterialResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteById(Long id) {
        this.materialRepository.deleteById(id);
    }

    @Transactional
    public void increaseViewCount(Map<Long, Long> viewCountToIds) {
        viewCountToIds.entrySet()
                .stream()
                .forEach(viewCountEntry -> this.materialRepository
                        .updateViewCount(viewCountEntry.getKey(), viewCountEntry.getValue()));
    }
}
