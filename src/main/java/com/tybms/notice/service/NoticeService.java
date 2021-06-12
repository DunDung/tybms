package com.tybms.notice.service;

import com.tybms.notice.dto.NoticeCreateRequest;
import com.tybms.notice.dto.NoticeResponse;
import com.tybms.notice.entity.Notice;
import com.tybms.notice.entity.NoticeAttachedFile;
import com.tybms.notice.repository.NoticeAttachedFileRepository;
import com.tybms.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeAttachedFileRepository noticeAttachedFileRepository;

    @Transactional
    public Notice save(NoticeCreateRequest noticeCreateRequest) {
        Notice notice = noticeCreateRequest.toNotice();
        Notice savedNotice = noticeRepository.save(notice);
        List<NoticeAttachedFile> noticeAttachedFiles = noticeCreateRequest.toNoticeAttachedFile();
        noticeAttachedFiles.forEach(noticeAttachedFile -> noticeAttachedFile.setNotice(savedNotice));
        noticeAttachedFileRepository.saveAll(noticeAttachedFiles);
        return notice;
    }

    @Transactional
    public List<NoticeResponse> findAll() {
        List<Notice> notices = noticeRepository.findAll();
        return notices.stream()
                .map(NoticeResponse::of)
                .collect(Collectors.toList());
    }
}
