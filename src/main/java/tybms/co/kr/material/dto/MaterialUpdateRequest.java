package tybms.co.kr.material.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MaterialUpdateRequest {

    @NotNull
    private Long id;

    @NotBlank(message = "제목은 비어있을 수 없습니다.")
    private String title;

    @NotBlank(message = "본문은 비어있을 수 없습니다.")
    private String content;

    @NotNull
    private List<String> fileNames;
}