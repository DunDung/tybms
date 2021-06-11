package com.tybms.entity;

import com.tybms.config.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Entity
public class Notice extends BaseEntity {

    private String title;
    private String content;

    @OneToMany(mappedBy = "notice", fetch = FetchType.LAZY)
    private List<NoticeAttachedFile> noticeAttachedFiles;

    public List<String> getAttachedFileNames() {
        return this.noticeAttachedFiles.stream()
                .map(NoticeAttachedFile::getName)
                .collect(Collectors.toList());
    }

}
