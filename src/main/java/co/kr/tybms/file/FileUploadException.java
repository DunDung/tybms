package co.kr.tybms.file;

public class FileUploadException extends RuntimeException {

    public FileUploadException(Exception e) {
        super("파일 업로드 중 오류가 발생했습니다.", e);
    }
}
