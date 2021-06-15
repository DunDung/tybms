package com.tybms.product.entity;

import com.tybms.config.BaseEntity;
import com.tybms.notice.entity.NoticeAttachedFile;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

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
public class Product extends BaseEntity {

    private String title;

    @ColumnDefault("0")
    private Long viewCount;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductAttachedFile> productAttachedFiles;

    public List<String> getProductAttachedFileNames() {
        return this.productAttachedFiles.stream()
                .map(ProductAttachedFile::getName)
                .collect(Collectors.toList());
    }

}