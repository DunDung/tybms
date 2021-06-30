package com.tybms.notice.repository;

import com.tybms.notice.entity.NoticeAttachedFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NoticeAttachedFileRepository extends JpaRepository<NoticeAttachedFile, Long> {

    @Transactional
    void deleteByName(String name);

    List<NoticeAttachedFile> findByNoticeId(Long id);
}
