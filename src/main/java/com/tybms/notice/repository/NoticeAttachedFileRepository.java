package com.tybms.notice.repository;

import com.tybms.notice.entity.NoticeAttachedFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeAttachedFileRepository extends JpaRepository<NoticeAttachedFile, Long> {
}
