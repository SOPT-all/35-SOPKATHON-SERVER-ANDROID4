package com.example.sopkathon.domian.gpt.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Data;

@Data
public class PingResponse {
    private String ping;

    public PingResponse(String ping) {
        this.ping = ping;
    }
}
