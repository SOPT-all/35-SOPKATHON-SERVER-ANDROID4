package com.example.sopkathon.common.advice;

import com.example.sopkathon.common.dto.Error;
import com.example.sopkathon.common.dto.Message;
import com.example.sopkathon.common.exception.BusinessException;
import com.example.sopkathon.common.message.BusinessErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 비즈니스 예외 처리
    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<Message> handleBusinessException(BusinessException e) {
        return ResponseEntity
                .status(e.getErrorMessage().getHttpStatus())
                .body(new Message(e.getErrorMessage().getMessage()));
    }

    // 기본 예외 처리
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Message> handleException(Exception e) {
        log.error("Unhandled exception occurred: {}", e.getMessage(), e);
        return ResponseEntity
                .status(BusinessErrorMessage.INTERNAL_SERVER_ERROR.getHttpStatus())
                .body(new Message(BusinessErrorMessage.INTERNAL_SERVER_ERROR.getMessage()));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Message> handleMissingServletRequestParameterException(final MissingServletRequestParameterException e) {
        final String errorMessage = "누락된 파라미터 : " + e.getParameterName();
        return ResponseEntity
                .status(BusinessErrorMessage.BAD_REQUEST.getHttpStatus())
                .body(new Message(errorMessage));
    }
}
