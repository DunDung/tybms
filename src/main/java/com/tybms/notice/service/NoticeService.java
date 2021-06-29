package com.tybms.notice.service;

import com.tybms.file.FileService;
import com.tybms.notice.dto.NoticeCreateRequest;
import com.tybms.notice.dto.NoticeResponse;
import com.tybms.notice.dto.NoticeUpdateRequest;
import com.tybms.notice.entity.Notice;
import com.tybms.notice.entity.NoticeAttachedFile;
import com.tybms.notice.repository.NoticeAttachedFileRepository;
import com.tybms.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeAttachedFileRepository noticeAttachedFileRepository;
    private final FileService fileService;

    @Transactional
    public Notice save(NoticeCreateRequest noticeCreateRequest) {
        Notice savedNotice = noticeRepository.save(noticeCreateRequest.toNotice());
        List<NoticeAttachedFile> noticeAttachedFiles = noticeCreateRequest.toNoticeAttachedFiles(savedNotice);
        noticeAttachedFileRepository.saveAll(noticeAttachedFiles);
        return savedNotice;
    }

    @Transactional
    public List<NoticeResponse> findAll() {
        List<Notice> notices = noticeRepository.findAll();
        return notices.stream()
                .map(NoticeResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public void increaseViewCount(Map<Long, Long> viewCountToIds) {
        viewCountToIds.forEach(this.noticeRepository::updateViewCount);
    }

    @Transactional
    public void deleteById(Long id) {
        noticeAttachedFileRepository.findByNoticeId(id).stream()
                .map(NoticeAttachedFile::getName)
                .forEach(fileService::deleteFile);
        this.noticeRepository.deleteById(id);
    }

    @Transactional
    public void update(NoticeUpdateRequest noticeUpdateRequest) {
        Notice noticeById = noticeRepository.findById(noticeUpdateRequest.getId())
                .map(notice -> notice.update(noticeUpdateRequest))
                .orElseThrow(NoSuchElementException::new);

        updateAttachedFiles(noticeUpdateRequest, noticeById);
    }

    private void updateAttachedFiles(NoticeUpdateRequest noticeUpdateRequest, Notice noticeById) {
        List<String> updatedFileNames = noticeUpdateRequest.getFileNames();
        List<String> preFileNames = noticeById.getNoticeAttachedFileNames();

        deletePreAttachedFiles(updatedFileNames, preFileNames);
        addUpdatedAttachedFiles(noticeById, updatedFileNames, preFileNames);
    }

    private void deletePreAttachedFiles(List<String> updatedFileNames, List<String> preFileNames) {
        preFileNames.stream()
                .filter(preFileName -> !updatedFileNames.contains(preFileName))
                .forEach(preFileName -> {
                    this.noticeAttachedFileRepository.deleteByName(preFileName);
                    this.fileService.deleteFile(preFileName);
                });
    }

    private void addUpdatedAttachedFiles(Notice noticeById, List<String> updatedFileNames, List<String> preFileNames) {
        updatedFileNames.stream()
                .filter(updatedFileName -> !preFileNames.contains(updatedFileName))
                .map(updatedFileName -> NoticeAttachedFile.builder()
                        .name(updatedFileName)
                        .notice(noticeById)
                        .build())
                .forEach(this.noticeAttachedFileRepository::save);
    }
}
