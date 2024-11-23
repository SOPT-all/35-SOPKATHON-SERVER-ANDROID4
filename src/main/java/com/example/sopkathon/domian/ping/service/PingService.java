package com.example.sopkathon.domian.ping.service;

import com.example.sopkathon.domian.ping.dto.res.PingListRes;
import com.example.sopkathon.domian.ping.repository.Ping;
import com.example.sopkathon.domian.ping.enums.PingStatusType;
import com.example.sopkathon.domian.ping.repository.PingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PingService {
    private final PingRepository pingRepository;

    public PingService(PingRepository pingRepository) {
        this.pingRepository = pingRepository;
    }

    public PingListRes getPingList(final String pingStatusType, final String uuid) {
        final List<Ping> foundPings = pingRepository.findByPingStatusAndUuid(pingStatusType, uuid);

        final List<PingListRes.PingInfo> foundPingInfos = foundPings.stream().map(
                ping -> PingListRes.PingInfo.of(ping.getId(), ping.getPing(), ping.getCreatedDate(), ping.getPingStatus())
        ).toList();
        return PingListRes.of(foundPingInfos);
    }
}
