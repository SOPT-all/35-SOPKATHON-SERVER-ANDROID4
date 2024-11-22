package com.example.sopkathon.common.advice;

import com.example.sopkathon.common.dto.Response;
import com.example.sopkathon.common.exception.BusinessException;
import com.example.sopkathon.common.message.BusinessErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 비즈니스 예외 처리
    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<Response<BusinessErrorMessage>> handleBusinessException(BusinessException e) {
        return ResponseEntity
                .status(e.getErrorMessage().getHttpStatus())
                .body(Response.fail(e.getErrorMessage()));
    }

    // 기본 예외 처리
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Response<BusinessErrorMessage>> handleException(Exception e) {
        log.error("Unhandled exception occurred: {}", e.getMessage(), e);
        return ResponseEntity
                .status(BusinessErrorMessage.INTERNAL_SERVER_ERROR.getHttpStatus())
                .body(Response.fail(BusinessErrorMessage.INTERNAL_SERVER_ERROR));
    }
}
