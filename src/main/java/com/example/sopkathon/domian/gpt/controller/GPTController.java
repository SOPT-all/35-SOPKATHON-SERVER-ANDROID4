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

        String message = prompt.getSituation() + " 해당 상황에 맞는 핑계를 100자 내외로 적어줘. 문단 형태로 적되 줄바꿈은 하지 마. 20살 대학생처럼 말해줘. 친구한테 말하듯이 말해줘";

        GPTRequest request = new GPTRequest(
                model, message, 1, 256, 1, 0, 0);

        GPTResponse gptResponse = restTemplate.postForObject(
                apiUrl, request, GPTResponse.class);

//        String content = gptResponse.getChoices().stream()
//                .map(choice -> choice.getMessage().getContent())
//                .collect(Collectors.joining(" "));

        String content = "얘들아, 진짜 미안한데… 나 이번엔 릴스 못 찍을 것 같아. 사실 얼마 전에 병원 갔더니, 무릎에 살짝 염증 있다고 하더라고. 운동도 자제하라길래 춤추는 건 완전 무리일 것 같아. 아니, 내가 평소엔 잘했을 텐데… (아픈 척 무릎 주물럭거리기) 진짜 몸이 안 받쳐주니 어쩔 수가 없네. 아니 근데 사실 내가 춤추는 순간, 파트 분위기 다 깨질까 봐 무서운 것도 있어. 몸치 박치 레벨 S급은 국제적 재난이란 말이야. 내가 아끼는 파트원들을 위해서 이 정도는 양보해줘!";

        return ResponseEntity.ok(new PingResponse(content));
    }
}
