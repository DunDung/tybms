package co.kr.tybms.notice.repository;

import co.kr.tybms.notice.entity.Notice;
import co.kr.tybms.notice.entity.NoticeAttachedFile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class NoticeAttachedFileRepositoryTest {

    private static final String TEST_NAME = "test_name";

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private NoticeAttachedFileRepository noticeAttachedFileRepository;

    private Notice notice;
    private NoticeAttachedFile noticeAttachedFile;

    @BeforeEach
    void setUp() {
        notice = noticeRepository.save(Notice.builder().build());
        noticeAttachedFile = NoticeAttachedFile.builder()
                .notice(notice)
                .name(TEST_NAME)
                .build();
    }

    @DisplayName("")
    @Test
    void deleteByName() {
        noticeAttachedFileRepository.save(noticeAttachedFile);

        noticeAttachedFileRepository.deleteByName(TEST_NAME);

        assertThat(noticeAttachedFileRepository.findAll()).extracting(List::size).isEqualTo(0);
    }

    @DisplayName("")
    @Test
    void findByNoticeId() {
        Notice savedNotice = noticeRepository.save(Notice.builder().build());
        NoticeAttachedFile noticeAttachedFile = NoticeAttachedFile.builder()
                .notice(savedNotice)
                .name(TEST_NAME)
                .build();
        noticeAttachedFileRepository.save(noticeAttachedFile);

        List<NoticeAttachedFile> expected = noticeAttachedFileRepository.findByNoticeId(savedNotice.getId());

        assertThat(expected.size()).isEqualTo(1);
    }

    @AfterEach
    void tearDown() {
        noticeAttachedFileRepository.deleteAll();
        noticeRepository.deleteAll();
    }
}