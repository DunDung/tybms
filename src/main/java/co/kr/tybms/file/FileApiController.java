package co.kr.tybms.file;

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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RequestMapping("/files")
@RequiredArgsConstructor
@RestController
public class FileApiController {

    private static final String INLINE_FILENAME = "inline;filename=";
    private static final String CONTENT_DISPOSITION = "content-disposition";

    private final FileService fileService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody List<MultipartFile> files) {
        fileService.uploadFiles(files);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<InputStreamResource> getTermsConditions(@PathVariable("name") String name) throws
            FileNotFoundException, UnsupportedEncodingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_DISPOSITION, INLINE_FILENAME + URLEncoder.encode(name, StandardCharsets.UTF_8.name()));
        File file = this.fileService.getFile(name);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_PDF_VALUE))
                .body(resource);
    }
}
