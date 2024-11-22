package com.example.sopkathon.common.message;

import org.springframework.http.HttpStatus;

// 기본 에러 메시지 형식
public interface DefaultErrorMessage {
    HttpStatus getHttpStatus();
    String getMessage();
}
