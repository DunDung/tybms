package com.tybms.notice.service;

import com.tybms.notice.entity.Notice;
import com.tybms.notice.entity.NoticeAttachedFile;
import com.tybms.notice.repository.NoticeAttachedFileRepository;
import com.tybms.notice.repository.NoticeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class NoticeServiceTest {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private NoticeAttachedFileRepository noticeAttachedFileRepository;

    @DisplayName("")
    @Test
    @Transactional
    void name() {
        Notice notice = Notice.builder()
                .title("title")
                .content("content")
                .viewCount(5L)
                .build();

        Notice savedNotice = noticeRepository.save(notice);

        NoticeAttachedFile noticeAttachedFile = NoticeAttachedFile.builder()
                .name("asd.pdf")
                .notice(savedNotice)
                .build();

        noticeAttachedFileRepository.save(noticeAttachedFile);

        Notice notice1 = noticeRepository.findAll().get(0);
        System.out.println(notice1.getNoticeAttachedFileNames());
    }
}