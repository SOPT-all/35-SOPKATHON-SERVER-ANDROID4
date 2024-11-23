package com.example.sopkathon.domian.ping.controller;

import com.example.sopkathon.domian.ping.dto.PingRequest;
import com.example.sopkathon.domian.ping.dto.PingStatusRequest;
import com.example.sopkathon.domian.ping.service.PingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pings")
public class PingController {
    private final PingService pingService;

    public PingController(PingService pingService) {
        this.pingService = pingService;
    }

    @PostMapping("/select")
    public void createPing(@RequestBody PingRequest pingRequest, @RequestHeader("Authorization") String token) {
        pingService.createPing(pingRequest.situation(), pingRequest.ping(), token);
    }

    @PatchMapping("/{pingId}")
    public void updatePingStatus(@RequestBody PingStatusRequest pingStatus, @RequestHeader("Authorization") String token, @PathVariable long pingId) {
        pingService.updatePingStatus(pingStatus.getPingStatus(), pingId);
    }
}
