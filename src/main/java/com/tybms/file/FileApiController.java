package com.tybms.file;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/files")
@RequiredArgsConstructor
@RestController
public class FileApiController {

    private final FileService fileService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody List<MultipartFile> files) {
        fileService.uploadFiles(files);
        return ResponseEntity.ok().build();
    }

}
