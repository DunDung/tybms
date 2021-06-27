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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product extends BaseEntity {

    @NotBlank(message = "제목은 비어있을 수 없습니다.")
    private String title;

    @ColumnDefault("0")
    private Long viewCount;

    @NotNull(message = "제품 카다로그에 첨부파일은 비어있을 수 없습니다.")
    private String attachedFile;

}