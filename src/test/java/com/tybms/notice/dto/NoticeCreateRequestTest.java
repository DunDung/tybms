package com.tybms.notice.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NoticeCreateRequestTest {

    @DisplayName("")
    @Test
    void name() {
        NoticeCreateRequest.builder()
                .content("")
                .title("")
                .fileNames(null)
                .build();
    }
}