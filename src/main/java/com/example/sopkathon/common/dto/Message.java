package com.example.sopkathon.common.dto;

public record Message(
        String message
) {
    public static Error of(String message) {
        return new Error(message);
    }
}