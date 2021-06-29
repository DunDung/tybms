package com.tybms.material.dto;


import com.tybms.material.entity.Material;
import com.tybms.material.entity.MaterialAttachedFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MaterialCreateRequest {

    @NotBlank(message = "제목은 비어있을 수 없습니다.")
    private String title;

    private String content;

    @NotNull
    private List<String> fileNames;

    public Material toMaterial() {
        return Material.builder()
                .title(title)
                .content(content)
                .build();
    }

    public List<MaterialAttachedFile> toMaterialAttachedFiles(Material material) {
        return this.fileNames.stream()
                .map(fileName -> MaterialAttachedFile.builder()
                        .name(fileName)
                        .material(material)
                        .build())
                .collect(Collectors.toList());
    }

}

