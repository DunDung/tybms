package co.kr.tybms.material.service;

import co.kr.tybms.file.FileService;
import co.kr.tybms.material.dto.MaterialCreateRequest;
import co.kr.tybms.material.dto.MaterialResponse;
import co.kr.tybms.material.dto.MaterialUpdateRequest;
import co.kr.tybms.material.entity.Material;
import co.kr.tybms.material.entity.MaterialAttachedFile;
import co.kr.tybms.material.repository.MaterialAttachedFileRepository;
import co.kr.tybms.material.repository.MaterialRepository;
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
public class MaterialService {

    private final MaterialRepository materialRepository;
    private final MaterialAttachedFileRepository materialAttachedFileRepository;
    private final FileService fileService;


    @CacheEvict(cacheNames = "MATERIALS")
    @Transactional
    public Material save(MaterialCreateRequest materialCreateRequest) {
        Material savedMaterial = this.materialRepository.save(materialCreateRequest.toMaterial());
        List<MaterialAttachedFile> materialAttachedFiles = materialCreateRequest.toMaterialAttachedFiles(savedMaterial);
        this.materialAttachedFileRepository.saveAll(materialAttachedFiles);
        return savedMaterial;
    }

    @Cacheable(cacheNames = "MATERIALS")
    @Transactional(readOnly = true)
    public List<MaterialResponse> findAll() {
        List<Material> materials = this.materialRepository.findAll();
        return materials.stream()
                .map(MaterialResponse::from)
                .collect(Collectors.toList());
    }

    @CacheEvict(cacheNames = "MATERIALS")
    @Transactional
    public void increaseViewCount(Map<Long, Long> viewCountToIds) {
        viewCountToIds.forEach(this.materialRepository::updateViewCount);
    }

    @CacheEvict(cacheNames = "MATERIALS")
    @Transactional
    public void deleteById(Long id) {
        materialAttachedFileRepository.findByMaterialId(id).stream()
                .map(MaterialAttachedFile::getName)
                .forEach(fileService::deleteFile);
        this.materialRepository.deleteById(id);
    }

    @CacheEvict(cacheNames = "MATERIALS")
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