package com.example.sopkathon.common.dto;

import com.example.sopkathon.common.message.DefaultErrorMessage;

// 응답 형식
public record Response<T> (
        boolean success,
        T data,
        Error error
) {
    public static <T> Response<T> success(final T data) {
        return new Response<>(true, data, null);
    }

    public static <T> Response<T> fail(DefaultErrorMessage errorMessage) {
        return new Response<>(false, null, Error.of(errorMessage.getMessage()));
    }
}
