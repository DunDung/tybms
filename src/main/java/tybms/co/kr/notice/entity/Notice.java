package tybms.co.kr.notice.entity;

import tybms.co.kr.config.BaseEntity;
import tybms.co.kr.notice.dto.NoticeUpdateRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Notice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String title;

    @Lob
    @Column
    private String content;

    @ColumnDefault("0")
    private Long viewCount;

    @OneToMany(mappedBy = "notice", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<NoticeAttachedFile> noticeAttachedFiles;

    public List<String> getNoticeAttachedFileNames() {
        return this.noticeAttachedFiles.stream()
                .map(NoticeAttachedFile::getName)
                .collect(Collectors.toList());
    }

    public Notice update(NoticeUpdateRequest noticeUpdateRequest) {
        this.title = noticeUpdateRequest.getTitle();
        this.content = noticeUpdateRequest.getContent();
        return this;
    }
}
