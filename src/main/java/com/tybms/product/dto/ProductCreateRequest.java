package com.tybms.product.dto;

import com.tybms.product.entity.Product;
import com.tybms.product.entity.ProductAttachedFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductCreateRequest {

    @NotBlank(message = "제목은 비어있을 수 없습니다.")
    private String title;

    @NotNull
    private List<String> fileNames;

    public Product toProduct() {
        return Product.builder()
                .title(title)
                .build();
    }

    public List<ProductAttachedFile> toProductAttachedFiles() {
        return this.fileNames.stream()
                .map(fileName -> ProductAttachedFile.builder()
                        .name(fileName)
                        .build())
                .collect(Collectors.toList());
    }

}
