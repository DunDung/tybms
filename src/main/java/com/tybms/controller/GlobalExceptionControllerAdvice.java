package com.tybms.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("IllegalArgumentException: {}", e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleIllegalArgumentException(Exception e) {
        log.error("Exception: {}", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("예상치 못한 에러가 발생했습니다.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        String defaultMessage = exception.getBindingResult().getAllErrors().get(0)
                .getDefaultMessage();
        log.error("MethodArgumentNotValidException: {}", defaultMessage);
        return ResponseEntity.badRequest().body(defaultMessage);
    }

}
