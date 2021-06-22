package com.tybms.material.entity;

import com.tybms.config.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Material extends BaseEntity {

    private String title;
    private String content;

    @ColumnDefault("0")
    private Long viewCount;

    // TODO: 2021-06-16 cascade ALL 이면 Material에만 List 추가하고 save하면 저장되야하는게 아닌가?
    @OneToMany(mappedBy = "material", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MaterialAttachedFile> materialAttachedFiles;

    public List<String> getMaterialAttachedFileNames() {
        return this.materialAttachedFiles.stream()
                .map(MaterialAttachedFile::getName)
                .collect(Collectors.toList());
    }

    public void setMaterialAttachedFiles(List<MaterialAttachedFile> materialAttachedFiles) {
        this.materialAttachedFiles = materialAttachedFiles;
    }

    public void increaseViewCount() {
        this.viewCount++;
    }
}