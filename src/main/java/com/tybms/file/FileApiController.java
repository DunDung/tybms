package com.tybms.file;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    @GetMapping("/{name}")
    public ResponseEntity<InputStreamResource> getTermsConditions(@PathVariable("name") String name) throws FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-disposition", "inline;filename=" + name);
        File file = this.fileService.getFile(name);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(resource);
    }

}
