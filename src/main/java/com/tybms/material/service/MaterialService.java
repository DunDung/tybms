package com.tybms.material.service;

import com.tybms.file.FileService;
import com.tybms.material.dto.MaterialCreateRequest;
import com.tybms.material.dto.MaterialResponse;
import com.tybms.material.dto.MaterialUpdateRequest;
import com.tybms.material.entity.Material;
import com.tybms.material.entity.MaterialAttachedFile;
import com.tybms.material.repository.MaterialAttachedFileRepository;
import com.tybms.material.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MaterialService {

    private final MaterialRepository materialRepository;
    private final MaterialAttachedFileRepository materialAttachedFileRepository;
    private final FileService fileService;


    @Transactional
    public Material save(MaterialCreateRequest materialCreateRequest) {
        Material savedMaterial = this.materialRepository.save(materialCreateRequest.toMaterial());
        List<MaterialAttachedFile> materialAttachedFiles = materialCreateRequest.toMaterialAttachedFiles(savedMaterial);
        this.materialAttachedFileRepository.saveAll(materialAttachedFiles);
        return savedMaterial;
    }

    @Transactional(readOnly = true)
    public List<MaterialResponse> findAll() {
        List<Material> materials = this.materialRepository.findAll();
        return materials.stream()
                .map(MaterialResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public void increaseViewCount(Map<Long, Long> viewCountToIds) {
        viewCountToIds.forEach(this.materialRepository::updateViewCount);
    }

    @Transactional
    public void deleteById(Long id) {
        materialAttachedFileRepository.findByMaterialId(id).stream()
                .map(MaterialAttachedFile::getName)
                .forEach(fileService::deleteFile);
        this.materialRepository.deleteById(id);
    }

    @Transactional
    public void update(MaterialUpdateRequest materialUpdateRequest) {
        Material materialById = this.materialRepository.findById(materialUpdateRequest.getId())
                .map(material -> material.update(materialUpdateRequest))
                .orElseThrow(NoSuchElementException::new);

        updateAttachedFiles(materialUpdateRequest, materialById);
    }

    private void updateAttachedFiles(MaterialUpdateRequest materialUpdateRequest, Material materialById) {
        List<String> updatedFileNames = materialUpdateRequest.getFileNames();
        List<String> preFileNames = materialById.getMaterialAttachedFileNames();

        deletePreAttachedFiles(updatedFileNames, preFileNames);
        addUpdatedAttachedFiles(materialById, updatedFileNames, preFileNames);
    }

    private void deletePreAttachedFiles(List<String> updatedFileNames, List<String> preFileNames) {
        preFileNames.stream()
                .filter(preFileName -> !updatedFileNames.contains(preFileName))
                .forEach(preFileName -> {
                    this.materialAttachedFileRepository.deleteByName(preFileName);
                    fileService.deleteFile(preFileName);
                });
    }

    private void addUpdatedAttachedFiles(Material materialById, List<String> updatedFileNames, List<String> preFileNames) {
        updatedFileNames.stream()
                .filter(updatedFileName -> !preFileNames.contains(updatedFileName))
                .map(updatedFileName -> MaterialAttachedFile.builder()
                        .name(updatedFileName)
                        .material(materialById)
                        .build())
                .forEach(this.materialAttachedFileRepository::save);
    }
}
