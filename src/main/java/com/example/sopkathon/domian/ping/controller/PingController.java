package com.example.sopkathon.domian.ping.controller;

import com.example.sopkathon.domian.ping.dto.PingRequest;
import com.example.sopkathon.domian.ping.repository.Ping;
import com.example.sopkathon.domian.ping.service.PingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pings")
public class PingController {
    private final PingService pingService;

    public PingController(PingService pingService) {
        this.pingService = pingService;
    }

    @PostMapping("/select")
    public void post(@RequestBody PingRequest pingRequest, @RequestHeader("Authorization") Long token) {
        pingService.createPing(pingRequest.situation(), pingRequest.ping(), token);
    }
}
