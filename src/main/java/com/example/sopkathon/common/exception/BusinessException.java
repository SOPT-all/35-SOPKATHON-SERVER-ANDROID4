package com.example.sopkathon.common.exception;

import com.example.sopkathon.common.message.DefaultErrorMessage;

public class BusinessException extends RuntimeException {
    private final DefaultErrorMessage errorMessage;

    public BusinessException(DefaultErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public DefaultErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
