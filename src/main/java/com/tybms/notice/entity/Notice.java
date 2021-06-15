package com.tybms.notice.entity;

import com.tybms.config.BaseEntity;
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
public class Notice extends BaseEntity {

    private String title;
    private String content;

    @ColumnDefault("0")
    private Long viewCount;

    @OneToMany(mappedBy = "notice", fetch = FetchType.LAZY)
    private List<NoticeAttachedFile> noticeAttachedFiles;

    public List<String> getNoticeAttachedFileNames() {
        return this.noticeAttachedFiles.stream()
                .map(NoticeAttachedFile::getName)
                .collect(Collectors.toList());
    }

    public void increaseViewCount() {
        this.viewCount++;
    }

}
