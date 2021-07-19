package tybms.co.kr.material.service;

import tybms.co.kr.file.FileService;
import tybms.co.kr.material.repository.MaterialAttachedFileRepository;
import tybms.co.kr.material.repository.MaterialRepository;
import tybms.co.kr.material.dto.MaterialCreateRequest;
import tybms.co.kr.material.dto.MaterialResponse;
import tybms.co.kr.material.dto.MaterialUpdateRequest;
import tybms.co.kr.material.entity.Material;
import tybms.co.kr.material.entity.MaterialAttachedFile;
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