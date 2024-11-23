package com.example.sopkathon.common.message;

import org.springframework.http.HttpStatus;

public enum PingErrorMessage implements DefaultErrorMessage {
    MISSING_REQUIRED_HEADER(HttpStatus.BAD_REQUEST, "필수 헤더가 누락되었습니다."),
    INVALID_STRING_LENGTH(HttpStatus.BAD_REQUEST, "요청 문자열의 길이는 1자 이상 200 이하여야 합니다."),
    INVALID_ID_TYPE(HttpStatus.BAD_REQUEST, "ID type이 number가 아닙니다."),
    ID_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, "ID에 해당하는 핑계를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다."),
    ;

    private HttpStatus httpStatus;
    private String message;

    PingErrorMessage(HttpStatus httpStatus, String message) {
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
