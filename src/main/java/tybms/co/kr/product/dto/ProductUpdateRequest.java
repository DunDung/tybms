package tybms.co.kr.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductUpdateRequest {

    @NotNull
    private Long id;

    @NotBlank(message = "제목은 비어있을 수 없습니다.")
    private String title;

    private String attachedFile;
}