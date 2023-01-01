package co.kr.tybms.notice.entity;

import co.kr.tybms.config.BaseEntity;
import co.kr.tybms.notice.dto.NoticeUpdateRequest;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Builder
@Audited
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
