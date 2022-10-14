package co.kr.tybms.notice.service;

import co.kr.tybms.file.FileService;
import co.kr.tybms.notice.dto.NoticeCreateRequest;
import co.kr.tybms.notice.dto.NoticeResponse;
import co.kr.tybms.notice.dto.NoticeUpdateRequest;
import co.kr.tybms.notice.entity.Notice;
import co.kr.tybms.notice.entity.NoticeAttachedFile;
import co.kr.tybms.notice.repository.NoticeAttachedFileRepository;
import co.kr.tybms.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

    @CacheEvict(cacheNames = "NOTICES", allEntries = true)
    @Transactional
    public Notice save(NoticeCreateRequest noticeCreateRequest) {
        Notice savedNotice = noticeRepository.save(noticeCreateRequest.toNotice());
        List<NoticeAttachedFile> noticeAttachedFiles = noticeCreateRequest.toNoticeAttachedFiles(savedNotice);
        noticeAttachedFileRepository.saveAll(noticeAttachedFiles);
        return savedNotice;
    }

    @Cacheable(cacheNames = "NOTICES")
    @Transactional(readOnly = true)
    public List<NoticeResponse> findAll() {
        List<Notice> notices = noticeRepository.findAll();
        return notices.stream()
                .map(NoticeResponse::from)
                .collect(Collectors.toList());
    }

    @CacheEvict(cacheNames = "NOTICES", allEntries = true)
    @Transactional
    public void increaseViewCount(Map<Long, Long> viewCountToIds) {
        viewCountToIds.forEach(this.noticeRepository::updateViewCount);
    }

    @CacheEvict(cacheNames = "NOTICES", allEntries = true)
    @Transactional
    public void deleteById(Long id) {
        noticeAttachedFileRepository.findByNoticeId(id).stream()
                .map(NoticeAttachedFile::getName)
                .forEach(fileService::deleteFile);
        this.noticeRepository.deleteById(id);
    }

    @CacheEvict(cacheNames = "NOTICES", allEntries = true)
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