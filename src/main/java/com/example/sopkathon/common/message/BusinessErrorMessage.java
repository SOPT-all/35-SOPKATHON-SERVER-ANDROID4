package com.example.sopkathon.common.message;

import org.springframework.http.HttpStatus;

// 비즈니스 에러 메시지
public enum BusinessErrorMessage implements DefaultErrorMessage {
    // 400 BAD_REQUEST
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    MISSING_REQUIRED_HEADER(HttpStatus.BAD_REQUEST, "필수 헤더가 누락되었습니다."),

    // 500 INTERNAL_SEVER_ERROR
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다."),
    NOT_FOUND_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "존재하지 않는 데이터입니다.")
    ;

    private HttpStatus httpStatus;
    private String message;

    BusinessErrorMessage(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
