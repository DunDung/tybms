package tybms.co.kr.notice.service;

import tybms.co.kr.file.FileService;
import tybms.co.kr.notice.repository.NoticeAttachedFileRepository;
import tybms.co.kr.notice.repository.NoticeRepository;
import tybms.co.kr.notice.dto.NoticeCreateRequest;
import tybms.co.kr.notice.dto.NoticeResponse;
import tybms.co.kr.notice.dto.NoticeUpdateRequest;
import tybms.co.kr.notice.entity.Notice;
import tybms.co.kr.notice.entity.NoticeAttachedFile;
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

    @Transactional(readOnly = true)
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