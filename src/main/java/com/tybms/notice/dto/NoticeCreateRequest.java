package com.tybms.notice.dto;

import com.tybms.notice.entity.Notice;
import com.tybms.notice.entity.NoticeAttachedFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NoticeCreateRequest {

    @NotBlank(message = "제목은 비어있을 수 없습니다.")
    private String title;

    @NotBlank(message = "본문은 비어있을 수 없습니다.")
    private String content;

    @NotNull
    private List<String> fileNames;

    public Notice toNotice() {
        return Notice.builder()
                .title(title)
                .content(content)
                .build();
    }

    public List<NoticeAttachedFile> toNoticeAttachedFiles(Notice notice) {
        return this.fileNames.stream()
                .map(fileName -> NoticeAttachedFile.builder()
                        .name(fileName)
                        .notice(notice)
                        .build())
                .collect(Collectors.toList());
    }
}
