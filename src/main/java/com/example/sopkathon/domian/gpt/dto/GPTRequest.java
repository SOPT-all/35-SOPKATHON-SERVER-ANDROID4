package com.example.sopkathon.domian.gpt.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GPTRequest {
    private String model;
    private List<GPTMessage> messages;
    private int temperature;
    private int maxTokens;
    private int topP;
    private int frequencyPenalty;
    private int presencePenalty;

    public GPTRequest(String model
            , String prompt
            , int temperature
            , int maxTokens
            , int topP
            , int frequencyPenalty
            , int presencePenalty) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new GPTMessage("user",prompt));
        this.temperature = temperature;
        this.maxTokens = maxTokens;
        this.topP=topP;
        this.frequencyPenalty=frequencyPenalty;
        this.presencePenalty = presencePenalty;
    }
}
