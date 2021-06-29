package com.tybms.notice.repository;

import com.tybms.notice.entity.NoticeAttachedFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeAttachedFileRepository extends JpaRepository<NoticeAttachedFile, Long> {

    void deleteByName(String name);

    List<NoticeAttachedFile> findByNoticeId(Long id);
}
