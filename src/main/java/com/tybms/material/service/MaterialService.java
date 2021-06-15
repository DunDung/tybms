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
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MaterialService {

    private final MaterialRepository materialRepository;
    private final MaterialAttachedFileRepository materialAttachedFileRepository;

    @Transactional
    public Material save(MaterialCreateRequest materialCreateRequest) {
        Material savedMaterial = materialRepository.save(materialCreateRequest.toMaterial());
        List<MaterialAttachedFile> materialAttachedFiles = materialCreateRequest.toMaterialAttachedFiles();
        materialAttachedFiles.forEach(materialAttachedFile -> materialAttachedFile.setMaterial(savedMaterial));
        materialAttachedFileRepository.saveAll(materialAttachedFiles);
        return savedMaterial;
    }

    @Transactional
    public List<MaterialResponse> findAll() {
        List<Material> materials = materialRepository.findAll();
        return materials.stream()
                .map(MaterialResponse::from)
                .collect(Collectors.toList());
    }

}
