package tybms.co.kr.product.entity;

import tybms.co.kr.config.BaseEntity;
import tybms.co.kr.product.dto.ProductUpdateRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotBlank(message = "제목은 비어있을 수 없습니다.")
    private String title;

    @ColumnDefault("0")
    private Long viewCount;

    @NotNull(message = "제품 카다로그에 첨부파일은 비어있을 수 없습니다.")
    private String attachedFile;

    public Product update(ProductUpdateRequest productUpdateRequest) {
        this.title = productUpdateRequest.getTitle();
        this.attachedFile = productUpdateRequest.getAttachedFile();
        return this;
    }

    public boolean isNotMatchAttachedFile(String attachedFile) {
        return !this.attachedFile.equals(attachedFile);
    }
}