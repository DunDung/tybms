package com.tybms.material.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tybms.material.entity.Material;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MaterialResponse {

    private Long id;
    private String title;
    private String content;
    private List<String> fileNames;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime modifiedDate;

    public static MaterialResponse from(Material material) {
        return MaterialResponse.builder()
                .id(material.getId())
                .title(material.getTitle())
                .content(material.getContent())
                .modifiedDate(material.getModifiedDate())
                .fileNames(material.getMaterialAttachedFileNames())
                .build();
    }

}