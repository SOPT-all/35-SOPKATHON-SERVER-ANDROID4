package com.example.sopkathon.common.dto;

// 에러 형식
public record Error(
        String message
) {
    public static Error of(String message) {
        return new Error(message);
    }
}
