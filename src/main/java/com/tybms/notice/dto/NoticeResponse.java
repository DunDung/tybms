package com.tybms.notice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tybms.notice.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class NoticeResponse {

    private Long id;
    private String title;
    private String content;
    private List<String> fileNames;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime modifiedDate;

    public static NoticeResponse from(Notice notice) {
        return NoticeResponse.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .modifiedDate(notice.getModifiedDate())
                .fileNames(notice.getNoticeAttachedFileNames())
                .build();
    }

}
