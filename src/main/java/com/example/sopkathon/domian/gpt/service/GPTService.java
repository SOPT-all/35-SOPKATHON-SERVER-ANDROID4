package com.example.sopkathon.domian.gpt.service;

import com.example.sopkathon.domian.gpt.dto.GPTPrompt;
import com.example.sopkathon.domian.gpt.dto.GPTRequest;
import com.example.sopkathon.domian.gpt.dto.GPTResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GPTService {
    @Value("${gpt.model}")
    private String model;

    @Value("${gpt.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public GPTService(RestTemplate restTemplate) {
        this.model = "gpt-3.5-turbo";
        this.restTemplate = restTemplate;
    }

    public GPTResponse generateResponse(GPTPrompt wordsRequest) {
        String prompt = String.join(", ", wordsRequest.getSentence()) +
                "해당 상황에 맞는 핑계를 작성해줘. 30자 이내 문단 형태로";

        GPTRequest request = new GPTRequest(model, prompt, 1, 256, 1, 0, 0);

        return restTemplate.postForObject(apiUrl, request, GPTResponse.class);
    }
}

