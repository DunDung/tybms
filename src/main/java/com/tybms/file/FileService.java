package com.tybms.file;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String BASE_DIR = System.getProperty("user.dir") + FILE_SEPARATOR + "upload-files";

    void uploadFiles(List<MultipartFile> files) {
        if (files == null) {
            return;
        }
        if (!new File(BASE_DIR).exists()) {
            new File(BASE_DIR).mkdir();
        }
        files.forEach(file -> {
            try {
                file.transferTo(getFile(file.getOriginalFilename()));
            } catch (IOException e) {
                throw new FileUploadException();
            }
        });
    }

    public boolean deleteFile(String fileName) {
        return getFile(fileName).delete();
    }

    File getFile(String fileName) {
        return new File(BASE_DIR + FILE_SEPARATOR + fileName);
    }

}
