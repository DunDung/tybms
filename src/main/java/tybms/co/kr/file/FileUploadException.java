package tybms.co.kr.file;

public class FileUploadException extends RuntimeException{

    public FileUploadException() {
        super("파일 업로드 중 오류가 발생했습니다.");
    }
}
