package com.example.sopkathon.domian.ping.controller;

import com.example.sopkathon.domian.ping.controller.dto.res.PingListRes;
import com.example.sopkathon.domian.ping.enums.PingStatusType;
import com.example.sopkathon.domian.ping.service.PingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pings")
public class PingController {
    private final PingService pingService;

    public PingController(PingService pingService) { this.pingService = pingService; }

//    @GetMapping("/my")
//    public ResponseEntity<PingListRes> getPingList(@RequestParam(value = "pingStatus", required = true) final PingStatusType pingStatusType) {
//        final PingListRes pingList = pingService.getPingList(pingStatusType);
//        return ResponseEntity.ok(pingList);
//    }
}
