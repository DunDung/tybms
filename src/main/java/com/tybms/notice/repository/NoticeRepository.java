package com.tybms.notice.repository;

import com.tybms.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Modifying
    @Query("UPDATE Notice set viewCount = viewCount + :expectedViewCount where id = :id")
    void updateViewCount(@Param("id") Long id, @Param("expectedViewCount") Long expectedViewCount);

}
