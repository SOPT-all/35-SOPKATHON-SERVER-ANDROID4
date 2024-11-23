package com.example.sopkathon.domian.ping.controller;

import com.example.sopkathon.common.exception.BusinessException;
import com.example.sopkathon.common.message.BusinessErrorMessage;
import com.example.sopkathon.common.message.PingErrorMessage;
import com.example.sopkathon.domian.ping.dto.res.PingListRes;
import com.example.sopkathon.domian.ping.enums.PingStatusType;
import com.example.sopkathon.domian.ping.service.PingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pings")
public class PingController {
    private final PingService pingService;

    public PingController(PingService pingService) { this.pingService = pingService; }

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
}
