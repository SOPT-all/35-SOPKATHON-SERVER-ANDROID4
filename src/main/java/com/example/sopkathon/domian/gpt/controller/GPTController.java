package com.example.sopkathon.domian.gpt.controller;

import com.example.sopkathon.domian.gpt.dto.GPTMessage;
import com.example.sopkathon.domian.gpt.dto.GPTPrompt;
import com.example.sopkathon.domian.gpt.dto.GPTRequest;
import com.example.sopkathon.domian.gpt.dto.GPTResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/gpt")
public class GPTController {

    @Value("${gpt.model}")
    private String model;
    @Value("${gpt.api.url}")
    private String apiUrl;
    private final RestTemplate restTemplate;

    public GPTController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/chat")
    public ResponseEntity<GPTResponse> chat(@RequestBody GPTPrompt prompt){

        // 단어 리스트를 문자열로 변환하고, GPT 요청에 사용할 프롬프트 생성
        String message = String.join(", ", prompt.getSentence()) + " 단어들을 이어붙여 문장을 만들어. 오직 결과 문장만 반환해";

        // GPT 요청 객체 생성
        GPTRequest request = new GPTRequest(
                model, message, 1, 256, 1, 0, 0);

        // GPT API 호출
        GPTResponse gptResponse = restTemplate.postForObject(
                apiUrl, request, GPTResponse.class);

        // 응답에서 생성된 문장 반환
        return ResponseEntity.ok(gptResponse);
    }

}

