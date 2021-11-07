package co.kr.tybms.notice.api;

import co.kr.tybms.notice.dto.NoticeCreateRequest;
import co.kr.tybms.notice.dto.NoticeResponse;
import co.kr.tybms.notice.dto.NoticeUpdateRequest;
import co.kr.tybms.notice.entity.Notice;
import co.kr.tybms.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notices")
public class NoticeApiController {

    private final NoticeService noticeService;

    @GetMapping
    public ResponseEntity<List<NoticeResponse>> findAll() {
        List<NoticeResponse> noticeResponses = this.noticeService.findAll();
        return ResponseEntity.ok(noticeResponses);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid NoticeCreateRequest noticeCreateRequest) {
        Notice savedNotice = this.noticeService.save(noticeCreateRequest);
        return ResponseEntity.created(URI.create("/" + savedNotice.getId())).build();
    }

    @PatchMapping
    public ResponseEntity<Void> increaseViewCount(@RequestBody Map<Long, Long> viewCountToIds) {
        this.noticeService.increaseViewCount(viewCountToIds);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody NoticeUpdateRequest noticeUpdateRequest) {
        this.noticeService.update(noticeUpdateRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.noticeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}