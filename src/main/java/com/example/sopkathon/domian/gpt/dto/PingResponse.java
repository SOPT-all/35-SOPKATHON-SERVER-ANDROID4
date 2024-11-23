package com.example.sopkathon.domian.gpt.dto;

import lombok.Data;

@Data
public class PingResponse {
    String ping;
    public PingResponse(String ping) {
        this.ping = ping;
    }
}
