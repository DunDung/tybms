package co.kr.tybms.file;

import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
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
    public ResponseEntity<byte[]> getFile(@PathVariable("name") String name) throws IOException {
        S3Object s3Object = this.fileService.getFile(name);
        byte[] bytes = IOUtils.toByteArray(s3Object.getObjectContent());

        String fileName = URLEncoder.encode(name, "UTF-8").replaceAll("\\+", "%20");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment", fileName);

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentLength(bytes.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(bytes);
    }
}
