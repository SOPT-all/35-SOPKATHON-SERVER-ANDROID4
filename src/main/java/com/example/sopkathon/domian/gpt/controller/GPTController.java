package com.example.sopkathon.domian.gpt.controller;

import com.example.sopkathon.domian.gpt.dto.GPTPrompt;
import com.example.sopkathon.domian.gpt.dto.GPTRequest;
import com.example.sopkathon.domian.gpt.dto.GPTResponse;
import com.example.sopkathon.domian.gpt.dto.PingResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@RestController
public class GPTController {

    @Value("${gpt.model}")
    private String model;
    @Value("${gpt.api.url}")
    private String apiUrl;
    private final RestTemplate restTemplate;

    public GPTController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/pings")
    public ResponseEntity<PingResponse> chat(@RequestBody GPTPrompt prompt){

        String message = prompt.getSituation() + " 해당 상황에 맞는 핑계를 1자 이상 200자 미만으로 적어줘. 줄바꿈은 하지 마.";

        GPTRequest request = new GPTRequest(
                model, message, 1, 256, 1, 0, 0);

        GPTResponse gptResponse = restTemplate.postForObject(
                apiUrl, request, GPTResponse.class);

        String content = gptResponse.getChoices().stream()
                .map(choice -> choice.getMessage().getContent())
                .collect(Collectors.joining(" "));

        return ResponseEntity.ok(new PingResponse(content));
    }
}
