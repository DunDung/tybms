package com.tybms.file;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    private static final String BASE_DIR = System.getProperty("user.dir") + "/upload-files";

    void uploadFiles(List<MultipartFile> files) {
        if (files == null) {
            return;
        }
        files.forEach(file -> {
            try {
                file.transferTo(getFile(file.getOriginalFilename()));
            } catch (IOException e) {
                throw new RuntimeException("파일 업로드 중 오류가 발생했습니다.");
            }
        });
    }

    public void deleteFile(String fileName) {
        File deleteFile = getFile(fileName);
        deleteFile.delete();
    }

    File getFile(String fileName) {
        return new File(BASE_DIR + fileName);
    }

}
