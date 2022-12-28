package co.kr.tybms.file;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    private final AmazonS3 amazonS3;

    public void uploadFiles(List<MultipartFile> files) {
        files.forEach(file -> {
            ObjectMetadata objMeta = new ObjectMetadata();
            try {
                objMeta.setContentLength(file.getInputStream().available());
                amazonS3.putObject(bucket, file.getOriginalFilename(), file.getInputStream(), objMeta);
            } catch (IOException e) {
                throw new FileUploadException(e);
            }
        });
    }

    public void deleteFile(String fileName) {
        amazonS3.deleteObject(bucket, fileName);
    }

    public S3Object getFile(String fileName) {
        return amazonS3.getObject(bucket, fileName);
    }
}
