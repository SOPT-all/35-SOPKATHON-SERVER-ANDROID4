package com.example.sopkathon.domian.gpt.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Data;

@Data
public class PingResponse {
    @JsonRawValue
    private final String ping;
    public PingResponse(String ping) {
        this.ping = ping;
    }
}
