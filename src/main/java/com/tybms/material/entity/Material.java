package com.tybms.material.entity;

import com.tybms.config.BaseEntity;
import com.tybms.material.dto.MaterialUpdateRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String title;

    @Lob
    @Column
    private String content;

    @ColumnDefault("0")
    private Long viewCount;

    @OneToMany(mappedBy = "material", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<MaterialAttachedFile> materialAttachedFiles;

    public List<String> getMaterialAttachedFileNames() {
        return this.materialAttachedFiles.stream()
                .map(MaterialAttachedFile::getName)
                .collect(Collectors.toList());
    }

    public Material update(MaterialUpdateRequest materialUpdateRequest) {
        this.title = materialUpdateRequest.getTitle();
        this.content = materialUpdateRequest.getContent();
        return this;
    }
}