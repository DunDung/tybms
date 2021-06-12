package com.tybms.material.entity;

import com.tybms.config.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Entity
public class Material extends BaseEntity {

    private String title;
    private String content;

    @OneToMany(mappedBy = "material", fetch = FetchType.LAZY)
    private List<MaterialAttachedFile> materialAttachedFiles;

    public List<String> getMaterialAttachedFileNames() {
        return this.materialAttachedFiles.stream()
                .map(MaterialAttachedFile::getName)
                .collect(Collectors.toList());
    }

}