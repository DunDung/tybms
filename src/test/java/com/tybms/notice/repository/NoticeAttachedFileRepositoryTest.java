package com.tybms.notice.repository;

import com.tybms.notice.entity.Notice;
import com.tybms.notice.entity.NoticeAttachedFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class NoticeAttachedFileRepositoryTest {

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private NoticeAttachedFileRepository noticeAttachedFileRepository;

    @DisplayName("")
    @Test
    void deleteByName() {
        Notice savedNotice = noticeRepository.save(Notice.builder().build());
        NoticeAttachedFile noticeAttachedFile = NoticeAttachedFile.builder()
                .notice(savedNotice)
                .name("안녕")
                .build();
        noticeAttachedFileRepository.save(noticeAttachedFile);

        noticeAttachedFileRepository.deleteByName("안녕");

        assertThat(noticeAttachedFileRepository.findAll()).extracting(List::size).isEqualTo(0);
    }

    @DisplayName("")
    @Test
    void findByNoticeId() {
        Notice savedNotice = noticeRepository.save(Notice.builder().build());
        NoticeAttachedFile noticeAttachedFile = NoticeAttachedFile.builder()
                .notice(savedNotice)
                .name("안녕")
                .build();
        noticeAttachedFileRepository.save(noticeAttachedFile);

        List<NoticeAttachedFile> expected = noticeAttachedFileRepository.findByNoticeId(savedNotice.getId());

        assertThat(expected.size()).isEqualTo(1);
    }
}