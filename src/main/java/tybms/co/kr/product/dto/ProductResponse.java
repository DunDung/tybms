package tybms.co.kr.product.dto;

import tybms.co.kr.product.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ProductResponse {

    private Long id;
    private String title;
    private Long viewCount;
    private String fileName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime modifiedDate;

    public static ProductResponse from(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .modifiedDate(product.getModifiedDate())
                .viewCount(product.getViewCount())
                .fileName(product.getAttachedFile())
                .build();
    }
}