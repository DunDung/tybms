package com.tybms.api;

import com.tybms.dto.NoticeCreateRequest;
import com.tybms.dto.NoticeResponse;
import com.tybms.entity.Notice;
import com.tybms.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notices")
public class NoticeApiController {

    private final NoticeService noticeService;

    @GetMapping
    public ResponseEntity<List<NoticeResponse>> findAll() {
        List<NoticeResponse> noticeResponses = noticeService.findAll();
        return ResponseEntity.ok(noticeResponses);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid NoticeCreateRequest noticeCreateRequest) {
        Notice savedNotice = noticeService.save(noticeCreateRequest);
        return ResponseEntity.created(URI.create("/" + savedNotice.getId())).build();
    }

}
