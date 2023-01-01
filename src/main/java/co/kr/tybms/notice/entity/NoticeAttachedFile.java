package co.kr.tybms.notice.entity;

import co.kr.tybms.config.BaseEntity;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@Entity
@Audited
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticeAttachedFile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NOTICE_ID")
    private Notice notice;
}
