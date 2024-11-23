package com.example.sopkathon.domian.ping.controller;

import com.example.sopkathon.domian.ping.dto.req.PingRequest;
import com.example.sopkathon.domian.ping.dto.req.PingStatusRequest;
import com.example.sopkathon.common.exception.BusinessException;
import com.example.sopkathon.common.message.PingErrorMessage;
import com.example.sopkathon.domian.ping.dto.res.PingListRes;
import com.example.sopkathon.domian.ping.service.PingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/pings")
public class PingController {
    private final PingService pingService;

    public PingController(PingService pingService) {
        this.pingService = pingService;
    }

    @GetMapping("/my")
    public ResponseEntity<PingListRes> getPingList(
            @RequestParam(value = "pingStatus", required = true) final String pingStatus,
            @RequestHeader("Authorization") String uuid
            ) {
        if (pingStatus.equals("success") || pingStatus.equals("fail") || pingStatus.equals("pending") || pingStatus.equals("all")) {
        } else {
            throw new BusinessException(PingErrorMessage.INVALID_PING_STATUS_TYPE);
        }
        final PingListRes pingList = pingService.getPingList(pingStatus, uuid);
        return ResponseEntity.ok(pingList);
    }
    @PostMapping("/select")
    public void createPing(@RequestBody PingRequest pingRequest, @RequestHeader("Authorization") String token) {
        pingService.createPing(pingRequest.situation(), pingRequest.ping(), token);
    }

    @PatchMapping("/{pingId}")
    public void updatePingStatus(@RequestBody PingStatusRequest pingStatus, @RequestHeader("Authorization") String token, @PathVariable long pingId) {
        pingService.updatePingStatus(pingStatus.getPingStatus(), pingId);
    }

    @GetMapping("/today")
    public ResponseEntity<PingListRes> getSuccessOtherPingList(
            @RequestHeader("Authorization") String uuid
    ) {
        final PingListRes successOtherPingLIst = pingService.getSuccessOtherPingList(uuid);
        return ResponseEntity.ok(successOtherPingLIst);
    }

    @DeleteMapping("/{pingId}")
    public void deletePing(@PathVariable long pingId) {
        pingService.deletePing(pingId);
    }
}
